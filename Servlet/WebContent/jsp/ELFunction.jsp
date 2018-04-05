<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/myfunction" prefix="my" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EL函数</title>
</head>
<body>

${my:add("woshi","qlqWWW")}

<!-- 判断是否包含标签 -->
${fn:contains("qweqwe", "qweq")} 


<!-- 判断是否包含标签(忽略大小写) -->
${fn:containsIgnoreCase("dsdsds", "DSDS")}

<!-- 判断是否以某个结束 -->
${fn:endsWith("1.txt", ".txt")}

<!-- 转义-->
 ${fn:escapeXml("<a href=''>点点</a>")}

<!-- 检索某个字符串-->
 ${fn:indexOf("WWWWE", "E")}
 
 <!-- 连接字符串 -->
 ${fn:join(arrayName, ";")}
 
 <!-- 求字符串或集合长度-->
  ${fn:length(StringArrayName)}

 <!-- 替换-->
${fn:replace("AAAAAAA",  "A","a")}

<!-- 分割字符串为字符串数组 -->
${fn:split(customerNames, ";")}

<!-- 判断一个字符串是否以指定字符串结束 -->
${fn:startsWith(product.id, "100-")}

<!-- 取子串，下标从5开始，取到末尾 -->
${fn:substring("woshiqiaoliqiang", 5, -1)}

<!-- 取子串，取第一个i之后的子串-->
${fn:substringAfter("woshiqiaoliqiang", "i")}

<!-- 取子串，取第一个q之前的子串-->
${fn:substringBefore("woshiqiaoliqiang", "q")}
<br/>
<!-- 变为小写 -->
${fn:toLowerCase("AAAAAAAAAAAAAAAAA")}

<!-- 变为大写 -->
${fn:toUpperCase("aaaaaaaaaaaa")}

</body>
</html>