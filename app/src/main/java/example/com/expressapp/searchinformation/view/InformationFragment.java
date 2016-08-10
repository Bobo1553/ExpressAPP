package example.com.expressapp.searchinformation.view;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.expressapp.R;
import example.com.expressapp.adminGUID;
import example.com.expressapp.searchinformation.Presenter.GetInfoPresenterImpl;
import example.com.expressapp.searchinformation.Presenter.iGetInfoPresenter;
import example.com.expressapp.searchinformation.model.ExpressInfoManager;
import example.com.expressapp.searchinformation.model.RecyclerViewAdapter;


public class InformationFragment extends Fragment implements iInformation{

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private adminGUID guid;
    private iGetInfoPresenter iSearch;
    private ExpressInfoManager mExpressInfoManager;
    private Handler handler=new Handler()
    {
        public void handleMessage(android.os.Message msg) {
            if(msg.what==1)
            {
                mExpressInfoManager.setExpressInfoList(msg.obj.toString());
                for(int i=0;i<mExpressInfoManager.getExpressInfoList().size();i++)
                {
                    Log.d("test",mExpressInfoManager.getExpressInfoList().get(i).getReceiverName());
                }
            }
        };
    };

    public InformationFragment(ExpressInfoManager expressInfoManager) {
        // Required empty public constructor
        this.mExpressInfoManager=expressInfoManager;
    }

    public String getGUID()
    {
        return guid.getGUID();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisView=inflater.inflate(R.layout.information_fragment_layout,container,false);
        iSearch=new GetInfoPresenterImpl(this);
        guid=(adminGUID)this.getActivity().getApplication();
        iSearch.judgeGetLadingInfo(handler);
        return thisView;
    }


}
