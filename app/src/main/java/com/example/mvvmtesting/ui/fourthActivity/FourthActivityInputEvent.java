package com.example.mvvmtesting.ui.fourthActivity;

public abstract class FourthActivityInputEvent {

    public static class loginButtonClick extends  FourthActivityInputEvent
    {
        private String Number;

        public String getNumber() {
            return Number;
        }

        public void setNumber(String number) {
            this.Number = number;
        }
    }
}
