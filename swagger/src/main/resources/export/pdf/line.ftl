<#escape x as x!"">
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <title>Title</title>
        <style>
            body {
                font-family: SimHei;
            }
        </style>
    </head>
    <body>
    <div class="color pos">
        <table>
            <caption>${sheetName}</caption>
            <thead>
            <tr>
                <td colspan="4">${sheetName} ${memo[0]}:${memo[2]} ${memo[1]}:${memo[3]}</td>
            </tr>
            <tr>
                <#list titles as title>
                    <td>${title}</td>
                </#list>
            </tr>
            </thead>
            <tbody>
            <#list list as item>
                <tr>
                    <td>${item.name}</td>
                    <td>${item.age}</td>
                    <td>${item.phoneNumber}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    </body>
    </html>
</#escape>
