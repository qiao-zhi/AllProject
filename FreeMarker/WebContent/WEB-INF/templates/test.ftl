    <html>  
      <head>  
            <title>freemarker测试</title>  
        </head>  
        <body>              
            <#list mylist as item>
				${item.name!}----------
				${item.password!}-------
				${item.sex!}----------
				${item.photo!}-----------<br/>
			</#list> 
        </body>  
    </html>  