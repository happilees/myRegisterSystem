package com.hsp.util;

/**
 * ���ܣ��������ʽ����Ƶת��Ϊflv��ʽ��������������Ƶ����
 * ǰ��������E���·��� ffmpeg.exe��ffplay.exep��threadGC2.dll��ffmpeg���� 
ffmpeg.rev12665.7z��
 *                 E���»��� mencoder.exe��drv43260.dll
 *  ps:   ffmpeg �ܽ����ĸ�ʽ��asx��asf��mpg��wmv��3gp��mp4��mov��avi��flv��
 *         mencoder ����ʣ�µĸ�ʽ��wmv9��rm��rmvb  
 *  author��������
 *  time��2010.12.9
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
public class ConvertFlv {
public static void savevedio(String oldvedio,String newvedio,String newphoto) {
//ConvertFlv.convert("E:\\���� ���ӿ�辫�ھ�����.mp4", "E:\\���� ���ӿ�辫�ھ�����.flv","E:\\���� ���ӿ�辫�ھ�����.jpg");
	ConvertFlv.convert(oldvedio,newvedio,newphoto);
}
/**
 *  ���ܺ���
 * @param inputFile ��������Ƶ�����·��
 * @param outputFile �������Ƶ�����·��
 * @return
 */
public static boolean convert(String inputFile, String outputFile,String newimg)
{
if (!checkfile(inputFile)) {
System.out.println(inputFile + " is not file");
return false;
}
if (process(inputFile,outputFile,newimg)) {
System.out.println("ok");
return true;
}
return false;
}
//����ļ��Ƿ����
private static boolean checkfile(String path) {
File file = new File(path);
if (!file.isFile()) {
return false;
}
return true;
}
/**
 * ת������ ���ȼ���ļ����ͣ��ھ������� processFlv����processAVI
 * @param inputFile
 * @param outputFile
 * @return
 */
private static boolean process(String inputFile,String outputFile,String newimg) {
int type = checkContentType( inputFile);
boolean status = false;
if (type == 0) {
String inputType = inputFile.substring(inputFile.lastIndexOf(".") + 1, inputFile.length()).toLowerCase();
if(inputType.equals("flv")){
processImg(inputFile, newimg);
System.out.println("ͼƬ������ɣ���");
}else{
status = processFLV(inputFile,outputFile,newimg);// ֱ�ӽ��ļ�תΪflv�ļ�
processImg(inputFile, newimg);
System.out.println("ֱ��ת�ͺ�ͼƬ������ɣ�");
}
} else if (type == 1) {
String avifilepath = processAVI(type,inputFile);
if (avifilepath == null)
return false;// avi�ļ�û�еõ�
status = processFLV(avifilepath,outputFile,newimg);// ��aviתΪflv
processImg(inputFile, newimg);
}
System.out.println("================status:"+status);
return status;
}
/**
 * �����Ƶ����
 * @param inputFile
 * @return ffmpeg �ܽ�������0�����ܽ�������1
 */
private static int checkContentType(String inputFile) {
String type = inputFile.substring(inputFile.lastIndexOf(".") + 1, inputFile.length()).toLowerCase();
// ffmpeg�ܽ����ĸ�ʽ����asx��asf��mpg��wmv��3gp��mp4��mov��avi��flv�ȣ�
if (type.equals("avi")) {
return 0;
} else if (type.equals("mpg")) {
return 0;
} else if (type.equals("wmv")) {
return 0;
} else if (type.equals("3gp")) {
return 0;
} else if (type.equals("mov")) {
return 0;
} else if (type.equals("mp4")) {
return 0;
} else if (type.equals("asf")) {
return 0;
} else if (type.equals("asx")) {
return 0;
} else if (type.equals("flv")) {
return 0;
}
// ��ffmpeg�޷��������ļ���ʽ(wmv9��rm��rmvb��),
// �������ñ�Ĺ��ߣ�mencoder��ת��Ϊavi(ffmpeg�ܽ�����)��ʽ.
else if (type.equals("wmv9")) {
return 1;
} else if (type.equals("rm")) {
return 1;
} else if (type.equals("rmvb")) {
return 1;
}
return 9;
}
/**
 *  ffmepg:	�ܽ����ĸ�ʽ����asx��asf��mpg��wmv��3gp��mp4��mov��avi��flv�ȣ�
 * @param inputFile
 * @param outputFile
 * @return
 */
private static boolean processFLV(String inputFile,String outputFile,String newimg) {
if (!checkfile(inputFile)) {
System.out.println(inputFile + " is not file");
return false;
}
 
List<String> commend = new java.util.ArrayList<String>();
//�;���
commend.add("F://ffmpeg");
commend.add("-i");
commend.add(inputFile);
commend.add("-ab");
commend.add("128");
commend.add("-acodec");
commend.add("libmp3lame");
commend.add("-ac");
commend.add("1");
commend.add("-ar");
commend.add("22050");
commend.add("-r");
commend.add("29.97");
//�߾���   ��-b 512 �޸ĳ�-qscale 6
//	commend.add("-qscale");
//	commend.add("6");
commend.add("-b");
commend.add("512");
commend.add("-y");
commend.add(outputFile);
StringBuffer test=new StringBuffer();
for(int i=0;i<commend.size();i++)
test.append(commend.get(i)+" ");
System.out.println(test);
try {
ProcessBuilder builder = new ProcessBuilder();
builder.command(commend);
builder.start();
return true;
} catch (Exception e) {
e.printStackTrace();
return false;
}
}
/**
 * Mencoder:
 *  ��ffmpeg�޷��������ļ���ʽ(wmv9��rm��rmvb��), 
�������ñ�Ĺ��ߣ�mencoder��ת��Ϊavi(ffmpeg�ܽ�����)��ʽ.
 * @param type
 * @param inputFile
 * @return
 */
private static String processAVI(int type,String inputFile) {
String name = inputFile.substring(0,inputFile.lastIndexOf("."))+".avi";
File file =new File(name);
if(file.exists())
        file.delete();
List<String> commend = new java.util.ArrayList<String>();
commend.add("F://mencoder");
commend.add(inputFile);
commend.add("-oac");
commend.add("mp3lame");
commend.add("-lameopts");
commend.add("preset=64");
  commend.add("-ovc");
  commend.add("xvid");
  commend.add("-xvidencopts");
  commend.add("bitrate=1000");
  commend.add("-of");
  commend.add("avi");
  commend.add("-o");
commend.add(name);

StringBuffer test=new StringBuffer();
for(int i=0;i<commend.size();i++)
test.append(commend.get(i)+" ");
System.out.println(test);
try 
{
ProcessBuilder builder = new ProcessBuilder();
builder.command(commend);
Process p=builder.start();
/**
 * ���Mencoder���� ��������ʹ�����
 * ��Ϊ��Щ����ƽ̨����Ա�׼�����������ṩ���޵Ļ�������С��
 * �����д�ӽ��̵��������������Ѹ�ٳ���ʧ�ܣ�����ܵ����ӽ����������������������� 
 */
final InputStream is1 = p.getInputStream();
final InputStream is2 = p.getErrorStream();
new Thread() {
public void run() {
BufferedReader br = new BufferedReader(	new InputStreamReader(is1));
try {
String lineB = null;
while ((lineB = br.readLine()) != null ){
if(lineB != null)System.out.println(lineB);
}
} catch (IOException e) {
e.printStackTrace();
}
}
}.start(); 
new Thread() {
public void run() {
BufferedReader br2 = new BufferedReader( new InputStreamReader(is2));
try {
String lineC = null;
while ( (lineC = br2.readLine()) != null){
if(lineC != null)System.out.println(lineC);
}
} catch (IOException e) {
e.printStackTrace();
}
}
}.start(); 

//��Mencoder����ת���������ٵ���ffmepg����
p.waitFor();
 System.out.println("who cares");
return name;
}catch (Exception e){ 
System.err.println(e); 
return null;
} 
}

/**
 * ��ͼ
 * @param inputFile
 * @param newimg
 */
public static void processImg(String inputFile,String newimg){
List<String> commend = new java.util.ArrayList<String>();
commend.add("F://ffmpeg");
commend.add("-i");
commend.add(inputFile);
commend.add("-y");
commend.add("-f");
    commend.add("image2");
    commend.add("-ss");
    commend.add("10");
    commend.add("-t");
    commend.add("0.001");
    commend.add("-s");
    commend.add("100x100");
    commend.add(newimg);
    
    StringBuffer test=new StringBuffer();
for(int i=0;i<commend.size();i++)
test.append(commend.get(i)+" ");
System.out.println("ͼƬ�������"+test.toString());
ProcessBuilder builder = new ProcessBuilder();
builder.command(commend);
try {
builder.start();
} catch (IOException e) {
e.printStackTrace();
}
}
}