/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlinx.serialization;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link TestGenerator.kt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("plugins/kotlin-serialization/kotlin-serialization-compiler/testData/boxIr")
@TestDataPath("$PROJECT_ROOT")
public class SerializationIrBoxTestGenerated extends AbstractSerializationIrBoxTest {
    @Test
    public void testAllFilesPresentInBoxIr() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/kotlin-serialization/kotlin-serialization-compiler/testData/boxIr"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
    }

    @Test
    @TestMetadata("classSerializerAsObject.kt")
    public void testClassSerializerAsObject() throws Exception {
        runTest("plugins/kotlin-serialization/kotlin-serialization-compiler/testData/boxIr/classSerializerAsObject.kt");
    }

    @Test
    @TestMetadata("metaSerializable.kt")
    public void testMetaSerializable() throws Exception {
        runTest("plugins/kotlin-serialization/kotlin-serialization-compiler/testData/boxIr/metaSerializable.kt");
    }

    @Test
    @TestMetadata("multimoduleInheritance.kt")
    public void testMultimoduleInheritance() throws Exception {
        runTest("plugins/kotlin-serialization/kotlin-serialization-compiler/testData/boxIr/multimoduleInheritance.kt");
    }

    @Test
    @TestMetadata("sealedInterfaces.kt")
    public void testSealedInterfaces() throws Exception {
        runTest("plugins/kotlin-serialization/kotlin-serialization-compiler/testData/boxIr/sealedInterfaces.kt");
    }
}
