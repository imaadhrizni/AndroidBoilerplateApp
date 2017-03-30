package base.imaadh.com.applicationboilerplate.data.job;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

/**
 * Created by Imaad on 3/30/2017.
 */

public class AppJobCreator implements JobCreator {
    @Override
    public Job create(String tag) {
        switch (tag) {
//            case JobA.TAG:
//                return new JobA();
            default:
                return null;
        }
    }
}