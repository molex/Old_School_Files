/*Copyright (c) 2009 Michael Brown
	This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

	This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
Or go online to: http://www.gnu.org/licenses/gpl-3.0.txt 
*/
 

package version2;



import com.google.wave.api.*;



@SuppressWarnings("serial")
public class Slashdot_RobotServlet extends  AbstractRobotServlet  {
	
	Gadget slashdotGadget = new Gadget("http//www.m1cr0sux0r.com/debug/slashdot.xml");
	
	@Override
	public void processEvents(RobotMessageBundle events) {
        for (Event event : events.getEvents()) {
                Wavelet wavelet = event.getWavelet();
                GadgetView gadgetView = wavelet.getRootBlip().getDocument().getGadgetView();

                switch (event.getType()) {
                        // Writing gadget state ...
                        case WAVELET_SELF_ADDED:
                        slashdotGadget.setField("id", "'" + wavelet.getWaveId() + "'");
                        slashdotGadget.setField("is-closed", new Boolean(false).toString());
                        gadgetView.append(slashdotGadget);
                        break;

                        // Reading gadget state ...
                        case DOCUMENT_CHANGED:
                        if (new Boolean(slashdotGadget.getField("is-closed"))) {
                                gadgetView.delete(slashdotGadget);
                        }//end if
                        
                }//end switch
                
        }//end for
        
	}//end process events
	
}//end Slashdot_RobotServlet