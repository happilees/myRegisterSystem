package com.hsp.util;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.record.Slide;
import org.apache.poi.hslf.usermodel.RichTextRun;
import org.apache.poi.hslf.usermodel.SlideShow;

public class PPTtoImage {
 public static List changppttoimage(String pptload,String newfullnewpath,int newsid){
  // 读入PPT文件
  File file = new File(pptload);
  return doPPTtoImage(file,newfullnewpath,newsid);
 }
 public static List doPPTtoImage(File file,String newfullnewpath,int newsid){
  /*boolean isppt = checkFile(file);
  if (!isppt) {
   System.out.println("你指定的文件不是ppt文档!");
   return false;
  }*/
  List al=new ArrayList();
  try {

   FileInputStream is = new FileInputStream(file);
   SlideShow ppt = new SlideShow(is);
   is.close();
   Dimension pgsize = ppt.getPageSize();
   org.apache.poi.hslf.model.Slide[] slide = ppt.getSlides();
   for (int i = 0; i < slide.length; i++) {
    //System.out.print("第" + i + "页。");
    if(slide[i].getNotesSheet()!=null&&slide[i].getNotesSheet().getTextRuns()!=null){
     //获取第一个备注
     //System.out.println("备注：" + slide[i].getNotesSheet().getTextRuns()[0].getText());
    }
    TextRun[] truns = slide[i].getTextRuns();
    for (int k = 0; k < truns.length; k++) {
     RichTextRun[] rtruns = truns[k].getRichTextRuns();
     for (int l = 0; l < rtruns.length; l++) {
      rtruns[l].setFontIndex(1);
      rtruns[l].setFontName("宋体");
      // 获取文本列表
      //System.out.println(rtruns[l].getText());   
     }
    }
    BufferedImage img = new BufferedImage(pgsize.width,
      pgsize.height, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = img.createGraphics();
    graphics.setPaint(Color.white);
    graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,
      pgsize.height));
    slide[i].draw(graphics);
    // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
    File f=new File(newfullnewpath);
	//判断该文件夹是否存在，如果不存在，这创建一个新的文件夹
	if(!f.isDirectory())
	{
		f.mkdirs();
	}
    FileOutputStream out = new FileOutputStream(newfullnewpath+"pict_"+(i + 1) + ".jpeg");
    javax.imageio.ImageIO.write(img, "jpeg", out);
    al.add("pict_"+(i + 1) + ".jpeg");
    out.close();
   }
   /*System.out.println("ok");
   return true;*/
  } catch (FileNotFoundException e) {
   System.out.println(e);
  } catch (IOException e) {
   e.printStackTrace();
  }
  return al;
 }

 // function 检查文件是否为PPT
 public static boolean checkFile(File file) {
  boolean isppt = false;
  String filename = file.getName();
  String suffixname = null;
  if (filename != null && filename.indexOf(".") != -1) {
   suffixname = filename.substring(filename.indexOf("."));
   if (suffixname.equals(".ppt")) {
    isppt = true;
   }
   return isppt;
  } else {
   return isppt;
  }
 }
}
