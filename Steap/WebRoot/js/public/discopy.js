$(function(){
	//禁止选择和复制
	document.oncontextmenu = function() {
      return false;
    }
    document.onkeydown = function() {
      if (window.event.ctrlKey && window.event.keyCode == 67) {
        return false;
      }
      return false;
    }
    document.body.oncopy = function() {
      return false;
    }
    document.onselectstart = function() {
      return false;
    }

  	document.onselectstart=function(){return false};
  	document.style.MozUserSelect="none";
  	document.onmousedown=function(){return false};
  	document.style.cursor = "default"; 
		      
	function disableSelection(target) {
        if (typeof target.onselectstart != "undefined") //IE route
            target.onselectstart = function() {
                return false
            }
        else if (typeof target.style.MozUserSelect != "undefined") //Firefox route
            target.style.MozUserSelect = "none"
        else
            //All other route (ie: Opera)
            target.onmousedown = function() {
                return false
            }
        target.style.cursor = "default"
    }
	
	var somediv = $("body");
    disableSelection(somediv) //disable text selection within DIV with id="mydiv"
})