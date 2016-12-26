function toVaild(){
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
   
    if(userName == ""||userName == null||password == ""||password == null){
    	alert("请填写完整！");
        return false;
        }
    else{
    	
    	return true;
    	}
    }

function toSelect(){
	var selectValue = document.getElementById("select").value;
    if(selectValue == ""||selectValue == null||selectValue == "0"){
    	alert("请选择执行操作！");
        return false;
        }
    else{
    	return true;
    	}
    }

function showExtractInfo(){
	
	
	var userName = document.getElementById("head_title").innerHTML;
	var dCode = document.getElementById("dCode").value;
	var mCode = document.getElementById("mCode").value;
	var wCode = document.getElementById("wCode").value;
	var mNumber = document.getElementById("mNumber").value;
	
	//首先判断用户是否在线。。
	if(userName == null||userName == ""){
		alert("用户不在线,请先登录！")
	}else{
		//其次再判断是否输入完整。。
		if(dCode == ""||dCode == null||mCode == ""||mCode == null||wCode == ""||wCode == null||mNumber == ""||mNumber == null){
			alert("请填写完整！");
		}else{
		
			document.getElementById("submit_info").style.display = "block";
			document.getElementById("submit_info").innerHTML = "您好！您的工作编号是"+dCode+"。您将从"+wCode+"编号的仓库"+"提取的药品编号为"+mCode+"的药品，数量为"+mNumber+"。确认完毕请提交申请单。";
			document.getElementById("input_button").style.display = "none";
			document.getElementById("submit_button").style.display = "block";
		}
	}
}

function showSupplierInfo(){
	
	var userName = document.getElementById("head_title").innerHTML;
	var sCode = document.getElementById("sCode").value;
	var mCode = document.getElementById("mCode").value;
	var wCode = document.getElementById("wCode").value;
	var mNumber = document.getElementById("mNumber").value;
	var mPrice = document.getElementById("mPrice").value;
	var allMoney = mPrice*mNumber;;
	
	//首先判断用户是否在线。。
	if(userName == null||userName == ""){
		alert("用户不在线,请先登录！")
	}else{
		//其次再判断是否输入完整。。
		if(sCode == ""||sCode == null||sCode == ""||mCode == null||wCode == ""||wCode == null||mNumber == ""||mNumber == null||mPrice == null||mPrice == ""||mPrice == null){
			alert("请填写完整！");
		}else{
		
			document.getElementById("submit_info").style.display = "block";
			document.getElementById("submit_info").innerHTML = "您好！您的供应商编号是"+sCode+"。您将在"+wCode+"编号的仓库"+"供应,药品编号为"+mCode+"的药品，数量为"+mNumber+"，单价为"+mPrice+"。" +
					"计算总额为"+allMoney+"。确认完毕请提交申请单。";
			document.getElementById("input_button").style.display = "none";
			document.getElementById("submit_button").style.display = "block";
		}
	}
	
	
}
function apply_operate(){
	return confirm('是否上传数据库！');
}



function show_register(){
	var str=prompt("请输入您的病历本ID","");
	if(str)
	{
		alert("您的ID是："+ str);
		window.location.href="Register_show_info?pID="+str+"";
	
	}
	

}








