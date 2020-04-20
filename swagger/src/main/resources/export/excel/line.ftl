<#escape x as x!"">
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
                <td>${item.lineName}</td>
                <td string>${item.intervalTimes}</td>
                <td string>${item.sites}</td>
                <td string>${item.intervalRate}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</#escape>