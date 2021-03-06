package spazm.spazm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import static spazm.spazm.MainActivity.currentIndex;
import static spazm.spazm.MainActivity.inComments;
import static spazm.spazm.MainActivity.inHotPost;

/**
 * A fragment that launches other parts of the demo application. Ignore this comment
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        getActivity().setTitle("Timeline");
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        GridView hotView = (GridView) rootView.findViewById(R.id.hotGridView);
        hotView.setAdapter(new HotPostsAdapter(getActivity()));

        // Give each picture in gridView button functionality
        hotView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                currentIndex = position;
                inHotPost = true;
                Intent intent = new Intent(getActivity(), ViewPostActivity.class);
                startActivity(intent);
            }
        });

        GridView timelineView = (GridView) rootView.findViewById(R.id.timeline);
        timelineView.setAdapter(new TimelineAdapter(getActivity()));

        // Give each picture in gridView button functionality
        timelineView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                currentIndex = position/2;
                inHotPost = false;
                inComments = false;
                Intent intent = new Intent(getActivity(), ViewPostActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}