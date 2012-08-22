<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="WebForm1.aspx.vb" Inherits="Program_4.WebForm1" %>

<%@ Register assembly="System.Web.DataVisualization, Version=3.5.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35" namespace="System.Web.UI.DataVisualization.Charting" tagprefix="asp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Untitled Page</title>
    <script language="javascript" type= "text/javasscript">
    function NumericOnly()
{
   //get value of key just pressed
   var keyCode = window.event.keyCode;

   //check to see if key pressed was 0 through 9
   if ( keyCode > 47 && keyCode < 58 )
      //numeric value so do nothing
      return;
   else if (keyCode = 8)
   //backspace
   return;
   else if (keyCode = 46)
   //decimal point
   return;
   else
      //they tried non-numeric value,
      window.event.returnValue = null; 
}
</script>

    <style type="text/css">
        .style1
        {
            width: 26%;
        }
        .style2
        {
            width: 159px;
        }
        .style3
        {
            width: 22%;
        }
        .style4
        {
            width: 106px;
        }
        .style5
        {
            width: 96px;
        }
        #TextArea1
        {
            text-align: center;
            width: 488px;
            height: 229px;
        }
        .style6
        {
            width: 26%;
            height: 212px;
        }
        .style7
        {
            width: 1311px;
        }
        .style8
        {
            width: 7%;
        }
        #rtxtLoanDetails
        {
            height: 209px;
            width: 372px;
        }
        .style9
        {
            width: 100%;
        }
    </style>
    
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <table align="center" class="style1">
            <tr>
                <td class="style2">
                    <asp:Label ID="Label1" runat="server" Text="Loan Amount"></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="txtAmount" runat="server" Width="200px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="style2">
                    <asp:Label ID="Label2" runat="server" Text="Term"></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="txtTerm" runat="server" Width="200px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="style2">
                    <asp:Label ID="Label3" runat="server" Text="Rate"></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="txtRate" runat="server" Width="200px"></asp:TextBox>
                </td>
            </tr>
        </table>
        <table align="center" class="style6">
            <tr>
                <td class="style7">
                    <asp:TextBox ID="rtxtDisplay" TextMode="multiline" runat="server" Height="184px" Width="387px"></asp:TextBox>
                </td>
            </tr>
        </table>
        <table align="center" class="style3">
            <tr>
                <td class="style4">
                    <asp:Button ID="btnCalculate" runat="server" Text="Calculate" Width="100px" />
                </td>
                <td class="style5">
                    <asp:Button ID="btnClear" runat="server" Text="Clear" Width="100px" />
                </td>
            </tr>
        </table>
        <table align="center" class="style9">
            <tr>
                <td>
                    <asp:Chart ID="Chart1" runat="server">
                        <Titles>
                            <asp:Title Name="Principal Remaining">
                            </asp:Title>
                        </Titles>
                        <Series>
                            <asp:Series ChartArea="Principal Remaining" Legend="Legend1" Name="Series1">
                            </asp:Series>
                        </Series>
                        <ChartAreas>
                            <asp:ChartArea Name="Principal Remaining">
                                <AxisY Title="Principal Amount">
                                </AxisY>
                                <AxisX Title="Principal Amount">
                                </AxisX>
                            </asp:ChartArea>
                        </ChartAreas>
                    </asp:Chart>
                </td>
            </tr>
        </table>
        <br />
        <table align="center" class="style8">
            <tr>
                <td>
                    <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/Default.aspx">Home</asp:HyperLink>
                </td>
            </tr>
        </table>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
    
    </div>
    </form>
</body>
</html>
