package pansong291.xposed.quickenergy.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;
import pansong291.xposed.quickenergy.R;

public class ListAdapter extends BaseAdapter
{
 private static ListAdapter adapter;

 public static ListAdapter get(Context c)
 {
  if(adapter == null)
   adapter = new ListAdapter(c);
  return adapter;
 }

 Context context;
 List<AlipayUser>list;
 List<String> selects;

 private ListAdapter(Context c)
 {
  context = c;
 }

 public void setAlipayUserList(List<AlipayUser> l)
 {
  list = l;
 }

 public void setSelectedList(List<String> l)
 {
  selects = l;
 }

 @Override
 public int getCount()
 {
  return list.size();
 }

 @Override
 public Object getItem(int p1)
 {
  return list.get(p1);
 }

 @Override
 public long getItemId(int p1)
 {
  return p1;
 }

 @Override
 public View getView(int p1, View p2, ViewGroup p3)
 {
  ViewHolder vh;
  if(p2 == null)
  {
   vh = new ViewHolder();
   p2 = LayoutInflater.from(context).inflate(R.layout.list_item, null);
   vh.tv = p2.findViewById(R.id.tv_idn);
   vh.cb = p2.findViewById(R.id.cb_list);
   p2.setTag(vh);
  }else
  {
   vh = (ViewHolder)p2.getTag();
  }

  AlipayUser au = list.get(p1);
  vh.tv.setText(au.name);
  vh.cb.setChecked(selects == null ? false: selects.contains(au.id));
  return p2;
 }

 class ViewHolder
 {
  TextView tv;
  CheckBox cb;
 }

}
