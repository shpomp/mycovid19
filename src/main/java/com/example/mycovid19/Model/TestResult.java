package com.example.mycovid19.Model;


public class TestResult {
  private String fn;
  private String ln;
  private String ts;
  private String td;

  public TestResult(String fn, String ln, String ts, String td) {
    this.fn = fn;
    this.ln = ln;
    this.ts = ts;
    this.td = td;
  }

  public String getFn() {
    return fn;
  }

  public void setFn(String fn) {
    this.fn = fn;
  }

  public String getLn() {
    return ln;
  }

  public void setLn(String ln) {
    this.ln = ln;
  }

  public String getTs() {
    return ts;
  }

  public void setTs(String ts) {
    this.ts = ts;
  }

  public String getTd() {
    return td;
  }

  public void setTd(String td) {
    this.td = td;
  }

  @Override
  public String toString() {
    return "TestResult{" +
        "fn='" + fn + '\'' +
        ", ln='" + ln + '\'' +
        ", ts='" + ts + '\'' +
        ", td='" + td + '\'' +
        '}';
  }
}
