package com.example.mvvmtesting.ui.fourthActivity;

public abstract class FourthActivityOutputEvent {

    public static class notifyUser extends FourthActivityOutputEvent
    {
        private String number;

        public void notifyUser(String nbr)
        {
            number = nbr;
        }

        public String getNumber() {
            return number;
        }
    }
}
