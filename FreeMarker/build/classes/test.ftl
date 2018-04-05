    <html>  
      <head>  
            <title>freemarker测试</title>  
        </head>  
        <body>              
            <#list arraylist as item>
				${item.name!}
				${item.password!}
				${item.sex!}
				${item.photo!}
			</#list> 
        </body>  
    </html>  