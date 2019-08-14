package pansong291.xposed.quickenergy.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import pansong291.xposed.quickenergy.Config;
import pansong291.xposed.quickenergy.R;

public class MainActivity extends Activity
{ 
 CheckBox cb_immediateEffect, cb_recordLog, cb_enableForest,
 cb_enableFarm, cb_collectEnergy, cb_helpFriendCollect,
 cb_receiveForestTaskAward, cb_rewardFriend, cb_sendBackAnimal,
 cb_receiveFarmToolReward, cb_useNewEggTool, cb_harvestProduce,
 cb_donation, cb_answerQuestion, cb_receiveFarmTaskAward,
 cb_feedAnimal, cb_useAccelerateTool, cb_notifyFriend,
 cb_receivePoint;

 @Override
 protected void onCreate(Bundle savedInstanceState)
 {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  setModuleActive(false);

  Config.shouldReloadConfig = true;

  cb_immediateEffect = findViewById(R.id.cb_immediateEffect);
  cb_recordLog = findViewById(R.id.cb_recordLog);
  cb_enableForest = findViewById(R.id.cb_enableForest);
  cb_enableFarm = findViewById(R.id.cb_enableFarm);
  cb_collectEnergy = findViewById(R.id.cb_collectEnergy);
  cb_helpFriendCollect = findViewById(R.id.cb_helpFriendCollect);
  cb_receiveForestTaskAward = findViewById(R.id.cb_receiveForestTaskAward);
  cb_rewardFriend = findViewById(R.id.cb_rewardFriend);
  cb_sendBackAnimal = findViewById(R.id.cb_sendBackAnimal);
  cb_receiveFarmToolReward = findViewById(R.id.cb_receiveFarmToolReward);
  cb_useNewEggTool = findViewById(R.id.cb_useNewEggTool);
  cb_harvestProduce = findViewById(R.id.cb_harvestProduce);
  cb_donation = findViewById(R.id.cb_donation);
  cb_answerQuestion = findViewById(R.id.cb_answerQuestion);
  cb_receiveFarmTaskAward = findViewById(R.id.cb_receiveFarmTaskAward);
  cb_feedAnimal = findViewById(R.id.cb_feedAnimal);
  cb_useAccelerateTool = findViewById(R.id.cb_useAccelerateTool);
  cb_notifyFriend = findViewById(R.id.cb_notifyFriend);
  cb_receivePoint = findViewById(R.id.cb_receivePoint);
 }

 @Override
 protected void onResume()
 {
  super.onResume();
  cb_immediateEffect.setChecked(Config.immediateEffect());
  cb_recordLog.setChecked(Config.recordLog());
  cb_enableForest.setChecked(Config.enableForest());
  cb_enableFarm.setChecked(Config.enableFarm());
  cb_collectEnergy.setChecked(Config.collectEnergy());
  cb_helpFriendCollect.setChecked(Config.helpFriendCollect());
  cb_receiveForestTaskAward.setChecked(Config.receiveForestTaskAward());
  cb_rewardFriend.setChecked(Config.rewardFriend());
  cb_sendBackAnimal.setChecked(Config.sendBackAnimal());
  cb_receiveFarmToolReward.setChecked(Config.receiveFarmToolReward());
  cb_useNewEggTool.setChecked(Config.useNewEggTool());
  cb_harvestProduce.setChecked(Config.harvestProduce());
  cb_donation.setChecked(Config.donation());
  cb_answerQuestion.setChecked(Config.answerQuestion());
  cb_receiveFarmTaskAward.setChecked(Config.receiveFarmTaskAward());
  cb_feedAnimal.setChecked(Config.feedAnimal());
  cb_useAccelerateTool.setChecked(Config.useAccelerateTool());
  cb_notifyFriend.setChecked(Config.notifyFriend());
  cb_receivePoint.setChecked(Config.receivePoint());
 }

 public void onClick(View v)
 {
  CheckBox cb = v instanceof CheckBox ? (CheckBox)v : null;
  Button btn = v instanceof Button ? (Button)v : null;
  switch(v.getId())
  {
   case R.id.cb_immediateEffect:
    Config.setImmediateEffect(cb.isChecked());
    break;

   case R.id.btn_showMode:
    ChoiceDialog.showShowMode(this, btn.getText());
    break;

   case R.id.cb_recordLog:
    Config.setRecordLog(cb.isChecked());
    break;

   case R.id.cb_enableForest:
    Config.setEnableForest(cb.isChecked());
    break;

   case R.id.cb_enableFarm:
    Config.setEnableFarm(cb.isChecked());
    break;

   case R.id.cb_collectEnergy:
    Config.setCollectEnergy(cb.isChecked());
    break;

   case R.id.cb_helpFriendCollect:
    Config.setHelpFriendCollect(cb.isChecked());
    break;

   case R.id.btn_dontCollectList:
    ListDialog.show(this, btn.getText(), Config.getDontCollectList());
    break;

   case R.id.btn_dontHelpCollectList:
    ListDialog.show(this, btn.getText(), Config.getDontHelpCollectList());
    break;

   case R.id.cb_receiveForestTaskAward:
    Config.setReceiveForestTaskAward(cb.isChecked());
    break;

   case R.id.btn_waterFriendList:
    ListDialog.show(this, btn.getText(), Config.getWaterFriendList());
    break;

   case R.id.cb_rewardFriend:
    Config.setRewardFriend(cb.isChecked());
    break;

   case R.id.cb_sendBackAnimal:
    Config.setSendBackAnimal(cb.isChecked());
    break;

   case R.id.btn_sendType:
    ChoiceDialog.showSendType(this, btn.getText());
    break;

   case R.id.btn_sendTypeExcludeList:
    ListDialog.show(this, btn.getText(), Config.getSendTypeExcludeList());
    break;

   case R.id.btn_recallAnimalType:
    ChoiceDialog.showRecallAnimalType(this, btn.getText());
    break;

   case R.id.cb_receiveFarmToolReward:
    Config.setReceiveFarmToolReward(cb.isChecked());
    break;

   case R.id.cb_useNewEggTool:
    Config.setUseNewEggTool(cb.isChecked());
    break;

   case R.id.cb_harvestProduce:
    Config.setHarvestProduce(cb.isChecked());
    break;

   case R.id.cb_donation:
    Config.setDonation(cb.isChecked());
    break;

   case R.id.cb_answerQuestion:
    Config.setAnswerQuestion(cb.isChecked());
    break;

   case R.id.cb_receiveFarmTaskAward:
    Config.setReceiveFarmTaskAward(cb.isChecked());
    break;

   case R.id.cb_feedAnimal:
    Config.setFeedAnimal(cb.isChecked());
    break;

   case R.id.cb_useAccelerateTool:
    Config.setUseAccelerateTool(cb.isChecked());
    break;

   case R.id.cb_notifyFriend:
    Config.setNotifyFriend(cb.isChecked());
    break;

   case R.id.btn_feedFriendAnimalList:
    ListDialog.show(this, btn.getText(), Config.getFeedFriendAnimal());
    break;

   case R.id.cb_receivePoint:
    Config.setReceivePoint(cb.isChecked());
    break;

   case R.id.btn_help:
    Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/pansong291/XQuickEnergy/wiki"));
    startActivity(it);
    break;

   case R.id.btn_donation_developer:
    Intent it2 = new Intent(Intent.ACTION_VIEW, Uri.parse("alipays://platformapi/startapp?saId=10000007&qrcode=https://qr.alipay.com/tsx00339eflkuhhtfctcn48"));
    startActivity(it2);
    break;
  }
 }

 @Override
 protected void onPause()
 {
  super.onPause();
  if(Config.hasConfigChanged)
  {
   Config.hasConfigChanged = !Config.saveConfigFile();
   Toast.makeText(this, "配置已保存", 0).show();
  }
  Config.saveIdMap();
 }

 private void setModuleActive(boolean b)
 {
  b = b || isExpModuleActive(this);
  TextView tv_unactive = findViewById(R.id.tv_unactive);
  tv_unactive.setVisibility(b ? View.GONE : View.VISIBLE);
 }

 private static boolean isExpModuleActive(Context context)
 {
  boolean isExp = false;
  if(context == null)
   throw new IllegalArgumentException("context must not be null!!");

  try
  {
   ContentResolver contentResolver = context.getContentResolver();
   Uri uri = Uri.parse("content://me.weishu.exposed.CP/");
   Bundle result = null;
   try
   {
    result = contentResolver.call(uri, "active", null, null);
   }catch(RuntimeException e)
   {
    // TaiChi is killed, try invoke
    try
    {
     Intent intent = new Intent("me.weishu.exp.ACTION_ACTIVE");
     intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     context.startActivity(intent);
    }catch(Throwable e1)
    {
     return false;
    }
   }
   if(result == null)
    result = contentResolver.call(uri, "active", null, null);

   if(result == null)
    return false;
   isExp = result.getBoolean("active", false);
  }catch(Throwable ignored)
  {
  }
  return isExp;
 }

}

