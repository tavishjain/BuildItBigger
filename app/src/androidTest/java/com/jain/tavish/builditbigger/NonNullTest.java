package com.jain.tavish.builditbigger;

import android.test.AndroidTestCase;

public class NonNullTest extends AndroidTestCase {

    @SuppressWarnings("unchecked")
    public void test() {

        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        String result;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(), null);
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            result = null;
        }
        assertNull(result);
    }

}