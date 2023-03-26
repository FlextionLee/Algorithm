package B형특강;

import java.util.Arrays;

public class 리스트복사 {
        public void init()
        {

        }

        public void makeList(char mName[], int mLength, int mListValue[])
        {
                for(int i=0; i<mLength; i++){
                        mName[i] = (char)mListValue[i];
                }

        }

        public void copyList(char mDest[], char mSrc[], boolean mCopy)
        {
        }

        public void updateElement(char mName[], int mIndex, int mValue)
        {
        }

        public int element(char mName[], int mIndex)
        {
            return 0;
        }
}
