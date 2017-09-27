/**
 * 
 */
package com.calango.MCP;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.calango.MCP.util.TransferNumberTests;
import com.calango.MCP.util.matrix.MatrixGeneratorTests;
import com.calango.MCP.util.matrix.MultiplyTests;

/**
 * @author calango
 *
 */
@RunWith(Suite.class)
@SuiteClasses({TransferNumberTests.class, MultiplyTests.class,
	MatrixGeneratorTests.class})
public class AllTests { }