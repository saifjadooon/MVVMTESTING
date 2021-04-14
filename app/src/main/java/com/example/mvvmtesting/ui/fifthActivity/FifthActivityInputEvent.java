package com.example.mvvmtesting.ui.fifthActivity;

public abstract class FifthActivityInputEvent  {

    public static class loginButtonClick extends FifthActivityInputEvent
    {

        private String email,pin;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPin() {
            return pin;
        }

        public void setPin(String pin) {
            this.pin = pin;
        }
    }

}
