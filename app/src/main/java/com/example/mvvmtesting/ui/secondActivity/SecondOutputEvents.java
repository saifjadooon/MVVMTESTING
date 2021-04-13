package com.example.mvvmtesting.ui.secondActivity;

public abstract class SecondOutputEvents {

    public static class NotifiyUser extends SecondOutputEvents {
        private String hMessage;

        public NotifiyUser(String hGetErrroInfo) {

            hMessage = hGetErrroInfo;
        }

        public String hGetMessage() {

            return hMessage;
        }
    }

}
