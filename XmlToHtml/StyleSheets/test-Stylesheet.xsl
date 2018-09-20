<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<html>
         <body>
            <h1>Company Details</h1>
            <table border="1">
               <tr>
                  <th>EmpId</th>
                  <th>EmpName</th>
                  <th>Age</th>
                  <th>Salary</th>
               </tr>
               <xsl:for-each select="Company/Info">
                  <tr>
                     <td>
                        <xsl:value-of select="EmpId" />
                     </td>
                     <td>
                        <xsl:value-of select="EmpName" />
                     </td>
                     <td>
                        <xsl:value-of select="Age" />
                     </td>
                     <td>
                        <xsl:value-of select="Salary" />
                     </td>
                  </tr>
               </xsl:for-each>
            </table>
         </body>
      </html>
		
	</xsl:template>
</xsl:stylesheet>