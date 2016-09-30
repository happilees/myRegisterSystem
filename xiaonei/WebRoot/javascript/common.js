/**************************************
控制文章内容中图片大小最宽不超过指定宽度
***************************************/
function ReImgSize(){
   for (i=0;i<document.images.length;i++)
   {
   if (document.all){
     if (document.images[i].width>550)
     {
       document.images[i].width="550"
       try{
           document.images[i].outerHTML='<a href="'+document.images[i].src+'" target="_blank" title="在新窗口打开图片">'+document.images[i].outerHTML+'</a>'
            }catch(e){}
       }
   }
   else{
     if (document.images[i].width>400) {
       document.images[i].title="在新窗口打开图片"
       document.images[i].style.cursor="pointer"
       document.images[i].onclick=function(e){window.open(this.src)}
     }
   }
   }
}

/*左右两边的表格自动适应高度*/
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
   var maxwidth=600;  //图片缩放后的宽度，可自行修改
   var maxheight=500;  //图片缩放后的高度，可自行修改
   var imgs = document.getElementById('Content_Page').getElementsByTagName('img');  //如果你定义的id不是content，请修改此处

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
alert("请输入用户名！");
document.getElementById("UserID").focus();
return false;
	}
if (oss2 == '')
{
alert("请输入密码！");
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
		alert("请输入用户名！");
		document.getElementById("Reg_UserID").focus();
		return false;
		}
	if (obj22 == "")
	{
		alert("请输入密码！");
		document.getElementById("Reg_Pwd").focus();
		return false;
		}
	if (obj33 == "")
	{
		alert("请输入确认密码！");
		document.getElementById("Reg_RePwd").focus();
		return false;
		}
	if (obj33 != obj22)
	{
		alert("两次密码输入不一致！");
		document.getElementById("Reg_Pwd").focus();
		return false;
		}
}

function honor(width,height)
{
var marquee1 = new Marquee("marquee")
   marquee1.Direction = "up";   //向上滚动
   marquee1.Step = 3;
   marquee1.Width = width;
   marquee1.Height = height;    //滚动区域高度
   marquee1.Timer = 20;
   marquee1.DelayTime = 5000;    //停留时间
   marquee1.WaitTime = 2000;
   marquee1.ScrollStep = 122;   //每次滚动高度
   marquee1.Start();	
}

function chk_search()
{
var cks = document.getElementById("keywords").value;
	if (cks == "")
	{
		alert("请输入查询信息！");
		document.getElementById("keywords").focus();
		return false;
	}

}


/**************************************
JS打开本地EXE文件
***************************************/
function Run(strPath) { 
exe.value=strPath; 
try { 
var objShell = new ActiveXObject("wscript.shell"); 
objShell.Run(strPath); 
objShell = null; 
} 
catch (e){alert('找不到文件"'+strPath+'"(或它的组件之一)。请确定路径和文件名是否正确后，再试一次。') 
} 
}

