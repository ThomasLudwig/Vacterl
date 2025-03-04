package fr.inserm.u1078.vacterl;

import fr.inserm.u1078.tludwig.maok.tools.Message;

/**
 * Class representing an SMAP file record
 */
public class Record implements Comparable<Record>{

  /**
   * The header for the Output file
   */
  public static final String OUT_HEADER = String.join("\t",
      "SOURCE",
      "RefcontigID1",
      "RefcontigID2",
      "RefStartPos",
      "RefEndPos",
      "Type",
      "Zygosity",
      "Present_in_percent_of_BNG_control_samples",
      "Present_in_percent_of_BNG_control_samples_with_the_same_enzyme",
      "OverlapGenes",
      "NearestNonOverlapGene"
  );


  /**
   * File Header for single sample files
   * This variable is not used, and just shown for reference
   */
  public static final String[] HEADERS_SINGLE = new String[]{
      "SmapEntryID",
      "QryContigID",
      "RefcontigID1",
      "RefcontigID2",
      "QryStartPos",
      "QryEndPos",
      "RefStartPos",
      "RefEndPos",
      "Confidence",
      "Type",
      "XmapID1",
      "XmapID2",
      "LinkID",
      "QryStartIdx",
      "QryEndIdx",
      "RefStartIdx",
      "RefEndIdx",
      "Zygosity",
      "Genotype",
      "GenotypeGroup",
      "RawConfidence",
      "RawConfidenceLeft",
      "RawConfidenceRight",
      "RawConfidenceCenter",
      "SVsize",
      "SVfreq",
      "Orientation",
      "VAF",
      "Sample",
      "Algorithm",
      "Size",
      "Present_in_%_of_BNG_control_samples",
      "Present_in_%_of_BNG_control_samples_with_the_same_enzyme",
      "%_of_BNG_control_sample_with_homozygous_SV",
      "%_of_BNG_control_sample_with_heterozygous_SV",
      "%_of_AFR_BNG_control_sample_with_SV",
      "%_of_AMR_BNG_control_sample_with_SV",
      "%_of_EUR_BNG_control_sample_with_SV",
      "%_of_EAS_BNG_control_sample_with_SV",
      "%_of_SAS_BNG_control_sample_with_SV",
      "%_of_unknown_BNG_control_sample_with_SV",
      "Fail_assembly_chimeric_score",
      "num_overlap_DGV_calls",
      "OverlapGenes",
      "NearestNonOverlapGene",
      "NearestNonOverlapGeneDistance",
      "PutativeGeneFusion",
      "Found_in_self_molecules",
      "Self_molecule_count",
      "UCSC_web_link1",
      "UCSC_web_link2",
      "ISCN"
  };

  /**
   * File Header for TRIO samples files
   * This variable is not used, and just shown for reference
   */
  public static final String[] HEADERS_TRIO = new String[]{
      "SmapEntryID",
      "QryContigID",
      "RefcontigID1",
      "RefcontigID2",
      "QryStartPos",
      "QryEndPos",
      "RefStartPos",
      "RefEndPos",
      "Confidence",
      "Type",
      "XmapID1",
      "XmapID2",
      "LinkID",
      "QryStartIdx",
      "QryEndIdx",
      "RefStartIdx",
      "RefEndIdx",
      "Zygosity",
      "Genotype",
      "GenotypeGroup",
      "RawConfidence",
      "RawConfidenceLeft",
      "RawConfidenceRight",
      "RawConfidenceCenter",
      "SVsize",
      "SVfreq",
      "Orientation",
      "VAF",
      "Sample",
      "Algorithm",
      "Size",
      "Present_in_%_of_BNG_control_samples",
      "Present_in_%_of_BNG_control_samples_with_the_same_enzyme",
      "%_of_BNG_control_sample_with_homozygous_SV",
      "%_of_BNG_control_sample_with_heterozygous_SV",
      "%_of_AFR_BNG_control_sample_with_SV",
      "%_of_AMR_BNG_control_sample_with_SV",
      "%_of_EUR_BNG_control_sample_with_SV",
      "%_of_EAS_BNG_control_sample_with_SV",
      "%_of_SAS_BNG_control_sample_with_SV",
      "%_of_unknown_BNG_control_sample_with_SV",
      "Fail_assembly_chimeric_score",
      "num_overlap_DGV_calls",
      "OverlapGenes",
      "NearestNonOverlapGene",
      "NearestNonOverlapGeneDistance",
      "PutativeGeneFusion",
      "Found_in_parents_assemblies",
      "Found_in_parents_molecules",
      "Found_in_self_molecules",
      "Mother_molecule_count",
      "Father_molecule_count",
      "Self_molecule_count",
      "UCSC_web_link1",
      "UCSC_web_link2",
      "ISCN"
  };

  /**
   * File Header for control sample files
   * This variable is not used, and just shown for reference
   */
  public static final String[] HEADERS_CONTROL = new String[]{
      "SmapEntryID",
      "QryContigID",
      "RefcontigID1",
      "RefcontigID2",
      "QryStartPos",
      "QryEndPos",
      "RefStartPos",
      "RefEndPos",
      "Confidence",
      "Type",
      "XmapID1",
      "XmapID2",
      "LinkID",
      "QryStartIdx",
      "QryEndIdx",
      "RefStartIdx",
      "RefEndIdx",
      "Zygosity",
      "Genotype",
      "GenotypeGroup",
      "RawConfidence",
      "RawConfidenceLeft",
      "RawConfidenceRight",
      "RawConfidenceCenter",
      "SVsize",
      "SVfreq",
      "Orientation",
      "VAF",
      "Sample",
      "Algorithm",
      "Size",
      "Present_in_%_of_BNG_control_samples",
      "Present_in_%_of_BNG_control_samples_with_the_same_enzyme",
      "%_of_BNG_control_sample_with_homozygous_SV",
      "%_of_BNG_control_sample_with_heterozygous_SV",
      "%_of_AFR_BNG_control_sample_with_SV",
      "%_of_AMR_BNG_control_sample_with_SV",
      "%_of_EUR_BNG_control_sample_with_SV",
      "%_of_EAS_BNG_control_sample_with_SV",
      "%_of_SAS_BNG_control_sample_with_SV",
      "%_of_unknown_BNG_control_sample_with_SV",
      "Fail_assembly_chimeric_score",
      "num_overlap_DGV_calls",
      "OverlapGenes",
      "NearestNonOverlapGene",
      "NearestNonOverlapGeneDistance",
      "PutativeGeneFusion",
      "Found_in_parents_assemblies",
      "Found_in_parents_molecules",
      "Found_in_self_molecules",
      "Control_molecule_count",
      "Self_molecule_count",
      "UCSC_web_link1",
      "UCSC_web_link2",
      "ISCN"
  };

  private final String source;
  private final int    SmapEntryID;
  private final int    QryContigID;
  private final int    RefcontigID1;
  private final int    RefcontigID2;
  private final double QryStartPos;
  private final double QryEndPos;
  private final double RefStartPos;
  private final double RefEndPos;
  private final double Confidence;
  private final String Type;
  private final int    XmapID1;
  private final int    XmapID2;
  private final int    LinkID;
  private final int    QryStartIdx;
  private final int    QryEndIdx;
  private final int    RefStartIdx;
  private final int    RefEndIdx;
  private final String Zygosity;
  private final int    Genotype;
  private final int    GenotypeGroup;
  private final double RawConfidence;
  private final double RawConfidenceLeft;
  private final double RawConfidenceRight;
  private final double RawConfidenceCenter;
  private final double SVsize;
  private final double SVfreq;
  private final String Orientation;
  private final double VAF;
  private final String Sample;
  private final String Algorithm;
  private final int    Size;
  private final double Present_in_percent_of_BNG_control_samples;
  private final double Present_in_percent_of_BNG_control_samples_with_the_same_enzyme;
  private final double percent_of_BNG_control_sample_with_homozygous_SV;
  private final double percent_of_BNG_control_sample_with_heterozygous_SV;
  private final double percent_of_AFR_BNG_control_sample_with_SV;
  private final double percent_of_AMR_BNG_control_sample_with_SV;
  private final double percent_of_EUR_BNG_control_sample_with_SV;
  private final double percent_of_EAS_BNG_control_sample_with_SV;
  private final double percent_of_SAS_BNG_control_sample_with_SV;
  private final double percent_of_unknown_BNG_control_sample_with_SV;
  private final String Fail_assembly_chimeric_score;
  private final int    num_overlap_DGV_calls;
  private final String OverlapGenes;
  private final String NearestNonOverlapGene;
  private final double NearestNonOverlapGeneDistance;
  private final String PutativeGeneFusion;
  private final String Found_in_parents_assemblies;
  private final String Found_in_parents_molecules;
  private final String Found_in_self_molecules;
  private final int    Mother_molecule_count;
  private final int    Father_molecule_count;
  private final int    Self_molecule_count;
  private final String UCSC_web_link1;
  private final String UCSC_web_link2;
  private final String ISCN;

  /**
   * Intantiate an Object for this Record
   * @param source the simplified name of the source file
   * @param line the line from the file
   */
  public Record(String source, String line) {
    this.source = source;
    int i = 0;
    String[] f = line.split("\t");
    //Check that the number of columns is valid (52 ,55 or 56)
    boolean single =f.length == HEADERS_SINGLE.length;//52 columns
    boolean withParent = f.length == HEADERS_TRIO.length;//56 columns
    boolean withControl = f.length == HEADERS_CONTROL.length;//55 columns
    if(!single && !withParent && !withControl)
      Message.die("Line has " + f.length + " columns");

    //Read the column content
    SmapEntryID = readInt(f,i++);
    QryContigID = readInt(f,i++);
    RefcontigID1 = readInt(f,i++);
    RefcontigID2 = readInt(f,i++);
    QryStartPos = readDouble(f,i++);
    QryEndPos = readDouble(f,i++);
    RefStartPos = readDouble(f,i++);
    RefEndPos = readDouble(f,i++);
    Confidence = readDouble(f,i++);
    Type = readString(f,i++);
    XmapID1 = readInt(f,i++);
    XmapID2 = readInt(f,i++);
    LinkID = readInt(f,i++);
    QryStartIdx = readInt(f,i++);
    QryEndIdx = readInt(f,i++);
    RefStartIdx = readInt(f,i++);
    RefEndIdx = readInt(f,i++);
    Zygosity = readString(f,i++);
    Genotype = readInt(f,i++);
    GenotypeGroup = readInt(f,i++);
    RawConfidence = readDouble(f,i++);
    RawConfidenceLeft = readDouble(f,i++);
    RawConfidenceRight = readDouble(f,i++);
    RawConfidenceCenter = readDouble(f,i++);
    SVsize = readDouble(f,i++);
    SVfreq = readDouble(f,i++);
    Orientation = readString(f,i++);
    VAF = readDouble(f,i++);
    Sample = readString(f,i++);
    Algorithm = readString(f,i++);
    Size = readInt(f,i++);
    Present_in_percent_of_BNG_control_samples = readDouble(f,i++);
    Present_in_percent_of_BNG_control_samples_with_the_same_enzyme = readDouble(f,i++);
    percent_of_BNG_control_sample_with_homozygous_SV = readDouble(f,i++);
    percent_of_BNG_control_sample_with_heterozygous_SV = readDouble(f,i++);
    percent_of_AFR_BNG_control_sample_with_SV = readDouble(f,i++);
    percent_of_AMR_BNG_control_sample_with_SV = readDouble(f,i++);
    percent_of_EUR_BNG_control_sample_with_SV = readDouble(f,i++);
    percent_of_EAS_BNG_control_sample_with_SV = readDouble(f,i++);
    percent_of_SAS_BNG_control_sample_with_SV = readDouble(f,i++);
    percent_of_unknown_BNG_control_sample_with_SV = readDouble(f,i++);
    Fail_assembly_chimeric_score = readString(f,i++);
    num_overlap_DGV_calls = readInt(f,i++);
    OverlapGenes = readString(f,i++);
    NearestNonOverlapGene = readString(f,i++);
    NearestNonOverlapGeneDistance = readDouble(f,i++);
    PutativeGeneFusion = readString(f,i++);
    Found_in_parents_assemblies = withParent || withControl ? readString(f,i++) : "-";
    Found_in_parents_molecules = withParent || withControl ? readString(f,i++) : "-";
    Found_in_self_molecules = readString(f,i++);
    Mother_molecule_count = withParent || withControl ? readInt(f,i++) : -1;
    Father_molecule_count = withParent ? readInt(f,i++) : -1;
    Self_molecule_count = readInt(f,i++);
    UCSC_web_link1 = readString(f,i++);
    UCSC_web_link2 = readString(f,i++);
    ISCN = readString(f,i++);
  }

  /**
   * Reading an Integer value from a String Array
   * @param f the String array
   * @param i the index in the array
   * @return the value of the Integer (-1 if IndexOutOfBound or value is not an Integer)
   */
  public static int readInt(String[] f, int i) {
    try{
      return Integer.parseInt(f[i]);
    } catch(ArrayIndexOutOfBoundsException obe) {
      Message.error("Line too short: "+i+" > "+f.length);
    } catch(NumberFormatException nfe){
      Message.warning("Could not read integer from ["+f[i]+"]");
    }
    return -1;
  }

  /**
   * Reading a Double value from a String Array
   * @param f the String array
   * @param i the index in the array
   * @return the value of the Double (-1 if IndexOutOfBound or value is not an Double)
   */
  public static double readDouble(String[] f, int i) {
    try{
      return Double.parseDouble(f[i]);
    } catch(ArrayIndexOutOfBoundsException obe) {
      Message.error("Line too short: "+i+" > "+f.length);
    } catch(NumberFormatException nfe){
      Message.warning("Could not read double from ["+f[i]+"]");
    }
    return -1;
  }

  /**
   * Reading String from a String Array
   * @param f the String array
   * @param i the index in the array
   * @return the ith String ("" if IndexOutOfBound)
   */
  public static String readString(String[] f, int i) {
    try{
      return f[i];
    } catch(ArrayIndexOutOfBoundsException obe) {
      Message.error("Line too short: "+i+" > "+f.length);
    }
    return "";
  }

  /**
   * Test of this Record passes the selection criteria
   * @param percentBNG max value for Present_in_%_of_BNG_control_samples (Line is dropped otherwise)
   * @param percentBNGSameEnzyme max value for Present_in_%_of_BNG_control_samples_with_the_same_enzyme (Line is dropped otherwise)
   * @return true if this Record passes the selection criteria
   */
  public boolean pass(double percentBNG, double percentBNGSameEnzyme) {
    return this.Present_in_percent_of_BNG_control_samples <= percentBNG && this.Present_in_percent_of_BNG_control_samples_with_the_same_enzyme <= percentBNGSameEnzyme;
  }

  /**
   * Gets the Contig for this Record
   * @return the Contig
   */
  public int getContig(){
    return this.RefcontigID1;
  }

  /**
   * Gets the start position for this Record
   *    * @return the start position for this Record
   */
  public double getStart(){
    return this.RefStartPos;
  }

  /**
   * Gets the end position for this Record
   * @return the end position for this Record
   */
  public double getEnd(){
    return this.RefEndPos;
  }

  /**
   * Gets A String representation for this Record
   * @return a String representation for this Record
   */
  @Override
  public String toString() {
    return String.join("\t",
        source,
        this.RefcontigID1+"",
        this.RefcontigID2+"",
        this.RefStartPos+"",
        this.RefEndPos+"",
        this.Type,
        this.Zygosity,
        this.Present_in_percent_of_BNG_control_samples+"",
        this.Present_in_percent_of_BNG_control_samples_with_the_same_enzyme+"",
        this.OverlapGenes,
        this.NearestNonOverlapGene
    );
  }

  /**
   * Compare a Record with this Record (for sorting purposes)
   * @param that the object to be compared.
   * @return negative if that Record is before this Record; positive if this Record is before that Record, 0 if the Records are collocated
   */
  @Override
  public int compareTo(Record that) {
    int diffContig = this.getContig() - that.getContig();
    if(diffContig == 0){
      double diffStart = this.getStart() - that.getStart();
      if(diffStart == 0) {
        double diffEnd = this.getEnd() - that.getEnd();
        if(diffEnd == 0)
          return 0;
        return diffEnd < 0 ? -1 : 1;
      }
      return diffStart < 0 ? -1 : 1;
    }
    return diffContig;
  }

  /**
   * Tests if a Record overlaps this Record
   * @param that the Record to test
   * @return true - if that Record overlaps this Record
   */
  public boolean overlaps(Record that) {
    if(this.getContig() != that.getContig())
      return false;
    if(this.getEnd() < that.getStart())
      return false;
    if(that.getEnd() < this.getStart())
      return false;
    return true;
  }
}
