package fr.inserm.u1078.vacterl;

import fr.inserm.u1078.tludwig.maok.SortedList;
import fr.inserm.u1078.tludwig.maok.tools.Message;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class representing a SMAP file
 */
public class SMAP {
  /**
   * SMAP File extension
   */
  public static final String EXT = ".smap";

  /**
   * name of the file
   */
  private final String name;
  /**
   * Records containing in the file
   */
  private final SortedList<Record> records;

  /**
   * Instantiate a new SMAP object
   * @param name the simplified name of the object
   * @param filename the input file name
   */
  public SMAP(String name, String filename){
    this.name = name;
    records = new SortedList<>(new ArrayList<Record>(), SortedList.Strategy.ADD_INSERT_SORT);
    try(BufferedReader in = new BufferedReader(new FileReader(filename))){
      //skip the 8 first lines (headers)
      for(int i = 0; i < 8; i++)
        in.readLine();
      String line;
      while((line = in.readLine()) != null)
        records.add(new Record(this.name, line));
    } catch(IOException e){
      System.err.println("Can't read data from ["+filename+"]");
    }
  }

  /**
   * The number of Records in this file
   * @return the number of Records in the file
   */
  public int size(){
    return this.records.size();
  }

  /**
   * The simplified name for this file
   * @return the simplified name for this file
   */
  public String getName() {
    return name;
  }

  /**
   * All the records that pass the given criteria
   * @param percentBNG max value for Present_in_%_of_BNG_control_samples (Line is dropped otherwise)
   * @param percentBNGSameEnzyme max value for Present_in_%_of_BNG_control_samples_with_the_same_enzyme (Line is dropped otherwise)
   * @return the list of records
   */
  public ArrayList<Record> getRecords(double percentBNG, double percentBNGSameEnzyme) {
    final ArrayList<Record> ret = new ArrayList<>();
    for(Record record : records)
      if(record.pass(percentBNG, percentBNGSameEnzyme))
        if(ret.isEmpty() || !ret.get(ret.size() -1).overlaps(record))
          ret.add(record);
    Message.info("Found for ["+this.name+"] "+ret.size());
    return ret;
  }
}
