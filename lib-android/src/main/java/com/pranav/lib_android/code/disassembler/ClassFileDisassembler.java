package com.pranav.lib_android.code.disassembler;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

import org.eclipse.jdt.internal.core.util.Disassembler;
import org.eclipse.jdt.core.util.ClassFormatException;

public class ClassFileDisassembler {
    
    final byte[] classFileBytes;
    
    public ClassFileDisassembler(String classFile) throws IOException {
		classFileBytes = Files.asByteSource(new File(classFile)).read();
    }
	
	public String disassemble() throws ClassFormatException {
		return new Disassembler().disassemble(classFileBytes, System.lineSeparator());
	}
}