package com.example.mvvmtesting.ui.secondActivity;

public abstract class SecondInputEvents {

    public static class OnLoginButtonClicked extends SecondInputEvents implements ErrorInfo {
        private String hText;


        public void hSetUserName(String text) {

            hText = text;
        }

        public String hGetText() {
            return hText;
        }

        @Override
        public String hGetErrroInfo() {
            if (hText != null && !hText.isEmpty()) {
                return "Good input";
            }else if (hText.isEmpty()) {
                return "Empty input";
            } else {
                return null;
            }
        }
    }


    public static class OnTest extends SecondInputEvents {

    }
}
