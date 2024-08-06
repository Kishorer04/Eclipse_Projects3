package anonymousInnerClassAsMethodArgument;

import java.io.File;
import java.io.FileFilter;

public class ShowHiddenFiles {

	public static void main(String[] args) {
		
		
		File[] hiddenFiles = new File("C:/Users/kravikumar/OneDrive - GalaxE. Solutions, Inc/Desktop")
		
		.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
	
				return file.isHidden();
			}
		});
		
		for(File f: hiddenFiles)
			System.out.println(f.getName());
		
		
		
//		File file = new File("C:/Users/kravikumar/OneDrive - GalaxE. Solutions, Inc/Desktop");
//		
//		File[] hiddenFiless =file.listFiles(new FileFilter() {
//
//			@Override
//			public boolean accept(File file) {
//				
//				return file.isHidden();
//			}
//		});
//		
//		for(File ff: hiddenFiless)
//			System.out.println(ff.getName());
//		
		

	}

}
