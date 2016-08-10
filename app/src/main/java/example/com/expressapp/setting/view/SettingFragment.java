package example.com.expressapp.setting.view;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.apache.commons.logging.Log;

import example.com.expressapp.R;
import example.com.expressapp.adminGUID;
import example.com.expressapp.setting.presenter.LogoutPresenterImpl;
import example.com.expressapp.setting.presenter.iLogoutPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment implements iSetting{
    private adminGUID guid;
    private iLogoutPresenter iLogout;
    private Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            if(msg.what==1)
            {
                android.util.Log.d("test",msg.obj.toString());
            }
        };
    };

    @Override
    public String getGUID()
    {
        return guid.getGUID();
    }

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisView=inflater.inflate(R.layout.setting_fragment_layout,container,false);
        iLogout=new LogoutPresenterImpl(this);
        guid=(adminGUID)getActivity().getApplication();
        Button button=(Button) thisView.findViewById(R.id.logout_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iLogout.LogoutJudge(handler);
            }
        });
        return thisView;
    }

}
