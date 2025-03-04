package fr.inserm.u1078.vacterl;

import fr.inserm.u1078.tludwig.maok.tools.Message;

import java.util.ArrayList;

/**
 * Program Main Class
 */
public class Main{
  /**
   * Entry point
   * @param args Command line arguments : percent, percentEnzyme, directory<br/>
   *             percentBNG : max value for Present_in_%_of_BNG_control_samples (Line is dropped otherwise)
   *             percentBNGEnzyme : max value for Present_in_%_of_BNG_control_samples_with_the_same_enzyme (Line is dropped otherwise)
   *             directory: The directory containing the .smap files
   */
  public static void main(String[] args) {
    if(args.length < 3)
      usage();

    double percent = 0;
    double percentEnzyme = 0;

    try {
      percent = Double.parseDouble(args[0]);
      percentEnzyme = Double.parseDouble(args[1]);
    } catch(NumberFormatException e){
      usage();
    }

    String directory = args[2];

    //Load data from the directory's .smap files
    Analyzer analyzer = new Analyzer(directory);
    //Select overlapping record according to criteria
    ArrayList<Group> groups = analyzer.getOverlapping(percent, percentEnzyme);

    //Print the number of groups/records
    int records = 0;
    for(Group group : groups)
      records += group.size();
    Message.info("Found "+groups.size()+" groups ("+records+" records)");

    //Outputs the results
    System.out.println("Group"+"\t"+"NbSamples"+"\t"+Record.OUT_HEADER);
    for(Group group : groups)
      group.print();
  }

  /**
   * Prints Command line usage
   */
  private static void usage(){
    Message.fatal("Usage : \n" +
        "java -jar <this.file.jar> percent percentEnzyme directory\n" +
        "<double> percentBNG: max value for Present_in_%_of_BNG_control_samples (Line is dropped otherwise)\n" +
        "<double> percentBNGEnzyme: max value for Present_in_%_of_BNG_control_samples_with_the_same_enzyme (Line is dropped otherwise)\n" +
        "<String> directory: The directory containing the "+SMAP.EXT+" files", true);
  }
}