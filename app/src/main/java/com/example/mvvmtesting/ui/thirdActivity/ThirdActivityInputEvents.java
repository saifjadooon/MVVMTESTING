package com.example.mvvmtesting.ui.thirdActivity;

public abstract class ThirdActivityInputEvents {

    public static class OnloginButtonClicked extends ThirdActivityInputEvents
    {

        private String hText;

        public String gethText() {
            return hText;
        }

        public void sethText(String hText) {
            this.hText = hText;
        }
    }
}
