package fr.inserm.u1078.vacterl;

import fr.inserm.u1078.tludwig.maok.tools.Message;

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
    if(r.getContig() != this.contig)
      Message.die("Uh Oh something went wrong, Group contig and Record contig are different, can't merge");
    this.start = Math.min(this.start, r.getStart());
    this.end   = Math.max(this.end,   r.getEnd());
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
    if(r.getEnd() < this.getStart())
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
