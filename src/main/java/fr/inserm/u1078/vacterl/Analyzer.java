package fr.inserm.u1078.vacterl;

import fr.inserm.u1078.tludwig.maok.SortedList;
import fr.inserm.u1078.tludwig.maok.tools.Message;

import java.io.File;
import java.util.ArrayList;

/**
 * Main working class. Loads .smap Files, creates groups, selects overlapping
 */
public class Analyzer {

  /**
   * All the .smap files in the directory
   */
  private final ArrayList<SMAP> smaps;

  /**
   * Instantiate an object containing all the .smap files
   * @param directory the directory where the .smap files are located
   */
  public Analyzer(final String directory) {
    this.smaps = new ArrayList<>();
    final File dir = new File(directory);
    if(!dir.exists()) {
      Message.die("Can't find directory [" + directory + "]");
      return;
    }
    File[] files = dir.listFiles();
    if(files == null) {
      Message.die("Directory [" + directory + "] is empty");
      return;
    }


    for(File file : files){
        final String filename = file.getAbsolutePath();
        final String name = file.getName().split("_")[0];
        if(filename.endsWith(SMAP.EXT)){
          Message.info("Processing "+filename);
          final SMAP smap = new SMAP(name, filename);
          Message.info(smap.getName()+" contains "+smap.size()+" records");
          this.smaps.add(smap);
        }
      }
    if(this.smaps.isEmpty())
      Message.die("No "+SMAP.EXT+" files where found in the directory ["+directory+"]");
  }

  /**
   * Returns a List of Groups. Each group contains overlapping records
   * @param percentBNG max value for Present_in_%_of_BNG_control_samples (Line is dropped otherwise)
   * @param percentBNGEnzyme max value for Present_in_%_of_BNG_control_samples_with_the_same_enzyme (Line is dropped otherwise)
   * @return the list of Groups
   */
  public ArrayList<Group> getOverlapping(final double percentBNG, final double percentBNGEnzyme){
    //The list is always sorted (Record is comparable on Contig,start,end)
    final SortedList<Record> sorted = new SortedList<>(new ArrayList<Record>(), SortedList.Strategy.ADD_INSERT_SORT);
    //Adding all the records from all the .smap files
    for(SMAP smap : smaps)
      sorted.addAll(smap.getRecords(percentBNG, percentBNGEnzyme));

    //For the "progress bar"
    //Total number of records
    final int total = sorted.size();
    //100th of the total
    final int step = total / 100;
    //records processed so far
    int processed = 0;


    Message.info("Building groups");
    final ArrayList<Group> groups = new ArrayList<>();
    for(Record record : sorted){
      //Add record to
      //1. the first group
      //2. an overlapping group
      //3. a new group
      if(groups.isEmpty())
        groups.add(new Group(record));
      else {
        final Group last = groups.get(groups.size() - 1);
        if(last.overlaps(record))
          last.add(record);
        else
          groups.add(new Group(record));
      }
      processed++;
      if(processed%step == 0)
        Message.progressInfo("Processed records "+processed+"/"+total+" Total groups "+groups.size());
    }
    Message.info("Processed records "+processed+"/"+total+" Total groups "+groups.size());

    final ArrayList<Group> overlapping = new ArrayList<>();
    int i = 0;
    for(Group group : groups)
      if(group.size() > 1) {//if the group contains more than 1 record, it is an overlapping record group
        overlapping.add(group);
        group.setID(i++);
      }
    return overlapping;
  }
}
