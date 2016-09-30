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
  // ����PPT�ļ�
  File file = new File(pptload);
  return doPPTtoImage(file,newfullnewpath,newsid);
 }
 public static List doPPTtoImage(File file,String newfullnewpath,int newsid){
  /*boolean isppt = checkFile(file);
  if (!isppt) {
   System.out.println("��ָ�����ļ�����ppt�ĵ�!");
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
    //System.out.print("��" + i + "ҳ��");
    if(slide[i].getNotesSheet()!=null&&slide[i].getNotesSheet().getTextRuns()!=null){
     //��ȡ��һ����ע
     //System.out.println("��ע��" + slide[i].getNotesSheet().getTextRuns()[0].getText());
    }
    TextRun[] truns = slide[i].getTextRuns();
    for (int k = 0; k < truns.length; k++) {
     RichTextRun[] rtruns = truns[k].getRichTextRuns();
     for (int l = 0; l < rtruns.length; l++) {
      rtruns[l].setFontIndex(1);
      rtruns[l].setFontName("����");
      // ��ȡ�ı��б�
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
    // ��������ͼƬ�Ĵ��·����ͼƬ�ĸ�ʽ(jpeg,png,bmp�ȵ�),ע�������ļ�·��
    File f=new File(newfullnewpath);
	//�жϸ��ļ����Ƿ���ڣ���������ڣ��ⴴ��һ���µ��ļ���
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

 // function ����ļ��Ƿ�ΪPPT
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
