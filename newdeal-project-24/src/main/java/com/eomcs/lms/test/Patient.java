package com.eomcs.lms.test;

public class Patient {
    private String _name;
    private int _age;
    private int _weight;
    private int _height;
    public String get_name() {
      return _name;
    }
    public void set_name(String _name) {
      this._name = _name;
    }
    public int get_age() {
    
      return _age;
    }
    public void set_age(int _age) {
      if(_age <1 || _age>200)
        return;
      this._age = _age;
    }
    public int get_weight() {
      return _weight;
    }
    public void set_weight(int _weight) {
      this._weight = _weight;
    }
    public int get_height() {
      return _height;
    }
    public void set_height(int _height) {
      this._height = _height;
    }

    

}
