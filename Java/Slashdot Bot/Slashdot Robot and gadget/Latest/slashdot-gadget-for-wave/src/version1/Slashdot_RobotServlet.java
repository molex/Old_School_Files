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


package version1;



import com.google.wave.api.*;



@SuppressWarnings("serial")
public class Slashdot_RobotServlet extends  AbstractRobotServlet  {
	@Override
	public void processEvents(RobotMessageBundle events) {
		for (Event event : events.getEvents()) {
			Gadget slashdotGadget;
			Wavelet wavelet = event.getWavelet();
			GadgetView gadgetView = wavelet.getRootBlip().getDocument().getGadgetView();

			switch (event.getType()) {
				// Writing gadget state ...
				case WAVELET_SELF_ADDED:
				slashdotGadget =
					new Gadget("http://www.m1cr0sux0r.com/debug/slashdot.xml");
				gadgetView.append(slashdotGadget);
				slashdotGadget.setField("addresses", "");
				break;

				// Reading gadget state ...
				case DOCUMENT_CHANGED:
				slashdotGadget = gadgetView.getGadget("http://www.m1cr0sux0r.com/debug/slashdot.xml");
				wavelet.getRootBlip().getDocument().append(slashdotGadget.getField("address"));
			}//end switch

		}//end for

	}//end process events

}//end Slashdot_RobotServlet