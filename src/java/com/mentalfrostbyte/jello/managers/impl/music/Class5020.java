package com.mentalfrostbyte.jello.managers.impl.music;

import java.io.IOException;

public class Class5020 extends Class4975 {
   private String field22980;

   public Class5020() {
      super("iTunes Metadata Name Box");
   }

   @Override
   public void method15262(DataStreamReader var1) throws IOException {
      super.method15262(var1);
      this.field22980 = var1.readString((int)this.method15430(var1));
   }

   public String method15382() {
      return this.field22980;
   }
}
