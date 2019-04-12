package com.mpogorzelski.app.technical_test;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by mpogorzelskil on 10/04/2019.
 */

public class AssetsClient<T> {
	
	private final Context context;
	private final String LOG_TAG = getClass().getSimpleName();
	private final JsonParser<T> parser;
	
	public AssetsClient(Context context, JsonParser<T> parser) {
		this.context = context;
		this.parser = parser;
	}
	
	private InputStream getFileInput(String pathToFile) throws IOException {
		return context.getAssets().open(pathToFile);
	}
	
	@Nullable
	public T get(String pathToFile) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = getBufferedReaderForFile(getFileInput(pathToFile));
			readIntoStringBuilder(br, sb);
		} catch (IOException e) {
			printException(e);
		} finally {
			close(br);
		}
		try {
			return parser.deserialize(sb.toString());
		} catch (IOException ex) {
			return null;
		}
	}
	
	@NonNull
	private BufferedReader getBufferedReaderForFile(InputStream fis) throws FileNotFoundException {
		return new BufferedReader(new InputStreamReader(fis));
	}
	
	private void readIntoStringBuilder(BufferedReader br, StringBuilder sb) throws IOException {
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
	}
	
	private void printException(Exception e) {
		Log.d(LOG_TAG, e.getMessage());
	}
	
	private void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				Log.d(LOG_TAG, e.getMessage());
			}
		}
	}
}
