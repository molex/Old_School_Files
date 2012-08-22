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
 

package version3;


import com.google.wave.api.*;



@SuppressWarnings("serial")
public class Slashdot_RobotServlet extends  AbstractRobotServlet {
	
	
	
	@Override
	public void processEvents(RobotMessageBundle bundle) {
		
		Wavelet wavelet = bundle.getWavelet();
		
		
		
		
		
		if (bundle.wasSelfAdded()) {
		      Blip blip = wavelet.appendBlip();
		      TextView textView = blip.getDocument();
		      textView.append("Cowboy Neal Is alive!");
		      
		   	  
		       
		      
		    }//end if
		
		for (Event e: bundle.getEvents()) {
		      if (e.getType() == EventType.WAVELET_PARTICIPANTS_CHANGED) {    
		        Blip blip = wavelet.appendBlip();
		        TextView textView = blip.getDocument();
		        textView.append("Share a Slashdot Story!");
		        
		      }//end if
		      
		}//end for
		
	}//end processEvents

	
			
}//end Slashdot_robotServlet
