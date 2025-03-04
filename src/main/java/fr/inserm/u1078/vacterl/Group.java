package fr.inserm.u1078.vacterl;

import java.util.ArrayList;

public class Group {
  private final ArrayList<Record> records;
  private final int contig;
  private double start;
  private double end;
  private int id;

  public Group(Record record) {
    this.records = new ArrayList<>();
    this.records.add(record);
    this.contig = record.getContig();
    this.start = record.getStart();
    this.end = record.getEnd();
  }

  public void add(Record r){
    if(r.getStart() < this.start)
      this.start = r.getStart();
    if(r.getEnd() > this.end)
      this.end = r.getEnd();
    this.records.add(r);
  }

  public int getContig() {
    return contig;
  }

  public double getStart() {
    return start;
  }

  public double getEnd() {
    return end;
  }

  public boolean overlaps(Record r){
    if(this.getContig() != r.getContig())
      return false;
    if(this.getEnd() < r.getStart())
      return false;
    if(this.getStart() > r.getEnd())
      return false;

    return true;
  }

  public int size(){
    return this.records.size();
  }

  public void setID(int id) {
    this.id = id;
  }

  public void print(){
    for(Record record : records)
      System.out.println("G"+id+"\t"+size()+"\t"+record.toString());
  }
}
