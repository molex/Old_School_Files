<%@ Page Language="VB" AutoEventWireup="true" CodeFile="Default.aspx.vb" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Untitled Page</title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:ScriptManager ID="ScriptManager1" runat="server" />
        <div>
            <ajaxToolkit:FilteredTextBoxExtender ID="FilteredTextBoxExtender1" 
                         runat="server" TargetControlID="TextBox1" FilterType="Numbers">                        
            </ajaxToolkit:FilteredTextBoxExtender> 
            <ajaxToolkit:FilteredTextBoxExtender ID="FilteredTextBoxExtender2" 
                         runat="server" TargetControlID="TextBox2" FilterType="LowercaseLetters">
            </ajaxToolkit:FilteredTextBoxExtender>
            <ajaxToolkit:FilteredTextBoxExtender ID="FilteredTextBoxExtender3" 
                         runat="server" TargetControlID="TextBox3" FilterType="Custom, Numbers" ValidChars="+-=/*().">
            </ajaxToolkit:FilteredTextBoxExtender>
            <table border="0">
                <tr>
                    <td>Only digits are allowed here:</td>
                    <td>
                        <asp:TextBox ID="TextBox1" runat="server">
                        </asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>
                        Only lower-case letters are allowed here:</td>
                    <td>
                        <asp:TextBox ID="TextBox2" runat="server">
                        </asp:TextBox></td>
                </tr>
                <tr>
                    <td>
                        Only math symbols (+,-,*,/,=,.) and numbers:</td>
                    <td>
                        <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox></td>
                </tr>
            </table>
        </div>
    </form>   
</body>
</html>
