package am.ipc.ipc_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class IPCFragment1 extends Fragment {

    EditText message;
    Button show;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment1View = inflater.inflate(R.layout.fragment1, container, false);
        message = fragment1View.findViewById(R.id.text_from_fragment1);
        show = fragment1View.findViewById(R.id.show_from_f1);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String text = message.getText().toString();
               MainActivity activity = (MainActivity) getActivity();
               activity.changeText(text);
            }
        });
        return fragment1View;
    }
}
