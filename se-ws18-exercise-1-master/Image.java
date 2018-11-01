 import java.io.IOException;
 import java.io.FileWriter;
 import java.io.FileOutputStream;
 
 public class Image {
 
 	/*A public byte array to store raw 24-bit RGB image data (3 bytes per pixel).*/
 	
 	public byte[] data;
 	
 	private int width, height;
 	
 	/*This is for constructor of Image class where parameters are widtha and height*/
 	public Image(int width, int height) {
 		this.width = width;
		this.height = height;
		data = new byte[width*height*3];
	}
 	/*A method set( int x, int y, int val ) which sets a single pixel at position (x,y) to the RGB value represented by val (Note: use zero-based indexing, i.e. the upper left corner pixel has position (0,0). Note: only consider the lower 24 bits of val). Parameter is x used for horizontal axis, parameter height used for vertical axis and parameter val is used for RGB value */
	
	/*Note: We took help from a friend for understanding RGB  and also got from stackoverflow
	 * https://stackoverflow.com/questions/4801366/convert-rgb-values-to-integer/4801433*/
	/*A method set( int x, int y, int val ) which sets a single pixel at position (x,y) 
	 * to the RGB value represented by val (Note: use zero-based indexing, i.e. the upper 
	 * left corner pixel has position (0,0). Note: only consider the lower 24 bits of val). 
	 * Parameter is x used for horizontal axis, parameter height used for vertical axis and 
	 * parameter val is used for RGB value */
	public void set(int x, int y, int val) {
		if (x > this.width && y > this.height) return;
         data[x*this.width*3 + y*3] = (byte)(val >> 16); // R bits
          data[x*this.width*3 + y*3 + 1] = (byte)((val >> 8 ) & 0xff); // G bits
          data[x*this.width*3 + y*3 + 2] = (byte)(val & 0xff); // B bits
     }
 	
 	/*Writes the image data to a file represented by filename. As image format, use the trivial PPM format with binary encoding. Parameter name is filename which is used for name of the output file*/
 	public void write(String filename) throws IOException {
 		boolean extension = filename.toUpperCase().endsWith(".PPM") || filename.toUpperCase().endsWith(".PNM");
 	    if (!extension) {
 			return;
 	    }
 		FileOutputStream out = new FileOutputStream(filename);
 		byte[] header = ("P3\n" + width + "\n" + height + "\n255\n").getBytes();
 		out.write(header);
 		out.write(data);
 		out.close();
 	}
 }