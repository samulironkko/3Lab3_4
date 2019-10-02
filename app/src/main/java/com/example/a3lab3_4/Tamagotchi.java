package com.example.a3lab3_4;

public class Tamagotchi extends Thread {
  private int foodLeft = 10;
  private int id;

  public void setFood() {
    foodLeft = foodLeft + 10;
  }

  public interface MyInterface {
    void updateStatus(int foodLeft, int id);
  }

  public Tamagotchi(MyInterface MyInterface, int i) {
    callBackInterface = MyInterface;
    id = i;
  }

  MyInterface callBackInterface = null;

  public void run() {
    try {
      while (foodLeft > 0 && foodLeft < 21) {
        callBackInterface.updateStatus(foodLeft, id);
        sleep(2000);
        foodLeft--;
      }
      callBackInterface.updateStatus(foodLeft, id);
    }catch (Exception e){
      e.printStackTrace();
    }


  }

}
