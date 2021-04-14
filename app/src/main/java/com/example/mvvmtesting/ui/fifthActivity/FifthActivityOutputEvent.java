package com.example.mvvmtesting.ui.fifthActivity;

public abstract class FifthActivityOutputEvent {

    public static class notifyUser extends  FifthActivityOutputEvent
    {

        private String Email,Pin;

        public void notifyUser (String email,String pin)
        {

            Email = email;
            Pin = pin;

        }

        public String getEmail() {
            return Email;
        }

        public String getPin() {
            return Pin;
        }
    }

}
