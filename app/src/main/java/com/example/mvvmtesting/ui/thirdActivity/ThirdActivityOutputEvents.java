package com.example.mvvmtesting.ui.thirdActivity;

public abstract class ThirdActivityOutputEvents {

    public static class NotifyUser extends ThirdActivityOutputEvents {
        private String Hmessage;

        public NotifyUser(String msg) {

            Hmessage = msg;
        }

        public String getHmessage() {
            return Hmessage;
        }
    }
}
