/**************************************
��������������ͼƬ��С�������ָ�����
***************************************/
function ReImgSize(){
   for (i=0;i<document.images.length;i++)
   {
   if (document.all){
     if (document.images[i].width>550)
     {
       document.images[i].width="550"
       try{
           document.images[i].outerHTML='<a href="'+document.images[i].src+'" target="_blank" title="���´��ڴ�ͼƬ">'+document.images[i].outerHTML+'</a>'
            }catch(e){}
       }
   }
   else{
     if (document.images[i].width>400) {
       document.images[i].title="���´��ڴ�ͼƬ"
       document.images[i].style.cursor="pointer"
       document.images[i].onclick=function(e){window.open(this.src)}
     }
   }
   }
}

/*�������ߵı���Զ���Ӧ�߶�*/
 function SetMiddle(_sId) {
            var theWidth;
            var theHeight;
            if (document.documentElement && document.documentElement.clientWidth) {
                theWidth = document.documentElement.clientWidth + document.documentElement.scrollLeft * 2;
                theHeight = document.documentElement.clientHeight + document.documentElement.scrollTop * 2;
            } else if (document.body) {
                theWidth = document.body.clientWidth;
                theHeight = document.body.clientHeight;
            } else if (window.innerWidth) {
                theWidth = window.innerWidth;
                theHeight = window.innerHeight;
            }
            _sId= document.getElementById(_sId)
            _sId.style.display = '';
            _sId.style.position = "absolute";
            _sId.style.left = (theWidth / 2) - (_sId.offsetWidth / 2) + "px";
            _sId.style.top = (theHeight / 2 + document.body.scrollTop) - (_sId.offsetHeight / 2) + "px";
           
        }

function setTab(m,n)
{  var menu=document.getElementById("tab"+m).getElementsByTagName("li");
	var div=document.getElementById("tablist"+m).getElementsByTagName("div");
	var showdiv=[]; 
for (i=0; j=div[i]; i++)
{  
	if ((" "+div[i].className+" ").indexOf(" tablist ")!=-1)
	{  showdiv.push(div[i]);  } 
}  
	for(i=0;i<menu.length;i++)  
	{  menu[i].className=i==n?"now":"";
	showdiv[i].style.display=i==n?"block":"none"; 
	}
}  


function ResizeImages()
{
   var myimg,oldwidth,oldheight;
   var maxwidth=600;  //ͼƬ���ź�Ŀ�ȣ��������޸�
   var maxheight=500;  //ͼƬ���ź�ĸ߶ȣ��������޸�
   var imgs = document.getElementById('Content_Page').getElementsByTagName('img');  //����㶨���id����content�����޸Ĵ˴�

   for(i=0;i<imgs.length;i++){
     myimg = imgs[i];

     if(myimg.width > myimg.height)
     {
         if(myimg.width > maxwidth)
         {
            oldwidth = myimg.width;
            myimg.height = myimg.height * (maxwidth/oldwidth);
            myimg.width = maxwidth;
         }
     }else{
         if(myimg.height > maxheight)
         {
            oldheight = myimg.height;
            myimg.width = myimg.width * (maxheight/oldheight);
            myimg.height = maxheight;
         }
     }
   }
}

function checklogin()
{
var oss1 = document.getElementById("UserID").value;
var oss2 = document.getElementById("Pwd").value;
if (oss1 == '')
{
alert("�������û�����");
document.getElementById("UserID").focus();
return false;
	}
if (oss2 == '')
{
alert("���������룡");
document.getElementById("Pwd").focus();
return false;
	}
	}

function CheckReg()
{
	var obj11 = document.getElementById("Reg_UserID").value;
	var obj22 = document.getElementById("Reg_Pwd").value;
	var obj33 = document.getElementById("Reg_RePwd").value;
	
	if (obj11 == "")
	{
		alert("�������û�����");
		document.getElementById("Reg_UserID").focus();
		return false;
		}
	if (obj22 == "")
	{
		alert("���������룡");
		document.getElementById("Reg_Pwd").focus();
		return false;
		}
	if (obj33 == "")
	{
		alert("������ȷ�����룡");
		document.getElementById("Reg_RePwd").focus();
		return false;
		}
	if (obj33 != obj22)
	{
		alert("�����������벻һ�£�");
		document.getElementById("Reg_Pwd").focus();
		return false;
		}
}

function honor(width,height)
{
var marquee1 = new Marquee("marquee")
   marquee1.Direction = "up";   //���Ϲ���
   marquee1.Step = 3;
   marquee1.Width = width;
   marquee1.Height = height;    //��������߶�
   marquee1.Timer = 20;
   marquee1.DelayTime = 5000;    //ͣ��ʱ��
   marquee1.WaitTime = 2000;
   marquee1.ScrollStep = 122;   //ÿ�ι����߶�
   marquee1.Start();	
}

function chk_search()
{
var cks = document.getElementById("keywords").value;
	if (cks == "")
	{
		alert("�������ѯ��Ϣ��");
		document.getElementById("keywords").focus();
		return false;
	}

}


/**************************************
JS�򿪱���EXE�ļ�
***************************************/
function Run(strPath) { 
exe.value=strPath; 
try { 
var objShell = new ActiveXObject("wscript.shell"); 
objShell.Run(strPath); 
objShell = null; 
} 
catch (e){alert('�Ҳ����ļ�"'+strPath+'"(���������֮һ)����ȷ��·�����ļ����Ƿ���ȷ������һ�Ρ�') 
} 
}

