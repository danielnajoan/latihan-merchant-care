package id.co.bca.magenta.api.merchantcare.util;

import io.swagger.v3.oas.annotations.media.Schema;

public class MultiRequest {
	@Schema(type = "string", format = "binary", description = "file upload")
	public String file;
//	@Schema(description = "file metadata")
//	public MetadataRequest metadataRequest;
}

/*class MetadataRequest {
	public String metadata;
}*/