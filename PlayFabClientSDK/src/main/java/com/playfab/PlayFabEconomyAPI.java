package com.playfab;

import com.playfab.internal.*;
import com.playfab.PlayFabEconomyModels.*;
import com.playfab.PlayFabErrors.*;
import com.playfab.PlayFabSettings;
import java.util.concurrent.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

    /** API methods for managing the catalog. Inventory manages in-game assets for any given entity. */
public class PlayFabEconomyAPI {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    /**
     * Creates a new item in the working catalog using provided metadata.
     * @param request CreateDraftItemRequest
     * @return Async Task will return CreateDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateDraftItemResponse>> CreateDraftItemAsync(final CreateDraftItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateDraftItemResponse>>() {
            public PlayFabResult<CreateDraftItemResponse> call() throws Exception {
                return privateCreateDraftItemAsync(request);
            }
        });
    }

    /**
     * Creates a new item in the working catalog using provided metadata.
     * @param request CreateDraftItemRequest
     * @return CreateDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateDraftItemResponse> CreateDraftItem(final CreateDraftItemRequest request) {
        FutureTask<PlayFabResult<CreateDraftItemResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateDraftItemResponse>>() {
            public PlayFabResult<CreateDraftItemResponse> call() throws Exception {
                return privateCreateDraftItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateDraftItemResponse> exceptionResult = new PlayFabResult<CreateDraftItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates a new item in the working catalog using provided metadata. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateDraftItemResponse> privateCreateDraftItemAsync(final CreateDraftItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/CreateDraftItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateDraftItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateDraftItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateDraftItemResponse>>(){}.getType());
        CreateDraftItemResponse result = resultData.data;

        PlayFabResult<CreateDraftItemResponse> pfResult = new PlayFabResult<CreateDraftItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates one or more upload URLs which can be used by the client to upload raw file data.
     * @param request CreateUploadUrlsRequest
     * @return Async Task will return CreateUploadUrlsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<CreateUploadUrlsResponse>> CreateUploadUrlsAsync(final CreateUploadUrlsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<CreateUploadUrlsResponse>>() {
            public PlayFabResult<CreateUploadUrlsResponse> call() throws Exception {
                return privateCreateUploadUrlsAsync(request);
            }
        });
    }

    /**
     * Creates one or more upload URLs which can be used by the client to upload raw file data.
     * @param request CreateUploadUrlsRequest
     * @return CreateUploadUrlsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<CreateUploadUrlsResponse> CreateUploadUrls(final CreateUploadUrlsRequest request) {
        FutureTask<PlayFabResult<CreateUploadUrlsResponse>> task = new FutureTask(new Callable<PlayFabResult<CreateUploadUrlsResponse>>() {
            public PlayFabResult<CreateUploadUrlsResponse> call() throws Exception {
                return privateCreateUploadUrlsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<CreateUploadUrlsResponse> exceptionResult = new PlayFabResult<CreateUploadUrlsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates one or more upload URLs which can be used by the client to upload raw file data. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<CreateUploadUrlsResponse> privateCreateUploadUrlsAsync(final CreateUploadUrlsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/CreateUploadUrls"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<CreateUploadUrlsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<CreateUploadUrlsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<CreateUploadUrlsResponse>>(){}.getType());
        CreateUploadUrlsResponse result = resultData.data;

        PlayFabResult<CreateUploadUrlsResponse> pfResult = new PlayFabResult<CreateUploadUrlsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Deletes all reviews, helpfulness votes, and ratings submitted by the entity specified.
     * @param request DeleteEntityItemReviewsRequest
     * @return Async Task will return DeleteEntityItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteEntityItemReviewsResponse>> DeleteEntityItemReviewsAsync(final DeleteEntityItemReviewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteEntityItemReviewsResponse>>() {
            public PlayFabResult<DeleteEntityItemReviewsResponse> call() throws Exception {
                return privateDeleteEntityItemReviewsAsync(request);
            }
        });
    }

    /**
     * Deletes all reviews, helpfulness votes, and ratings submitted by the entity specified.
     * @param request DeleteEntityItemReviewsRequest
     * @return DeleteEntityItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteEntityItemReviewsResponse> DeleteEntityItemReviews(final DeleteEntityItemReviewsRequest request) {
        FutureTask<PlayFabResult<DeleteEntityItemReviewsResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteEntityItemReviewsResponse>>() {
            public PlayFabResult<DeleteEntityItemReviewsResponse> call() throws Exception {
                return privateDeleteEntityItemReviewsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteEntityItemReviewsResponse> exceptionResult = new PlayFabResult<DeleteEntityItemReviewsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Deletes all reviews, helpfulness votes, and ratings submitted by the entity specified. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteEntityItemReviewsResponse> privateDeleteEntityItemReviewsAsync(final DeleteEntityItemReviewsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/DeleteEntityItemReviews"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteEntityItemReviewsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteEntityItemReviewsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteEntityItemReviewsResponse>>(){}.getType());
        DeleteEntityItemReviewsResponse result = resultData.data;

        PlayFabResult<DeleteEntityItemReviewsResponse> pfResult = new PlayFabResult<DeleteEntityItemReviewsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Removes an item from working catalog and all published versions from the public catalog.
     * @param request DeleteItemRequest
     * @return Async Task will return DeleteItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<DeleteItemResponse>> DeleteItemAsync(final DeleteItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<DeleteItemResponse>>() {
            public PlayFabResult<DeleteItemResponse> call() throws Exception {
                return privateDeleteItemAsync(request);
            }
        });
    }

    /**
     * Removes an item from working catalog and all published versions from the public catalog.
     * @param request DeleteItemRequest
     * @return DeleteItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<DeleteItemResponse> DeleteItem(final DeleteItemRequest request) {
        FutureTask<PlayFabResult<DeleteItemResponse>> task = new FutureTask(new Callable<PlayFabResult<DeleteItemResponse>>() {
            public PlayFabResult<DeleteItemResponse> call() throws Exception {
                return privateDeleteItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<DeleteItemResponse> exceptionResult = new PlayFabResult<DeleteItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Removes an item from working catalog and all published versions from the public catalog. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<DeleteItemResponse> privateDeleteItemAsync(final DeleteItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/DeleteItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<DeleteItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<DeleteItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<DeleteItemResponse>>(){}.getType());
        DeleteItemResponse result = resultData.data;

        PlayFabResult<DeleteItemResponse> pfResult = new PlayFabResult<DeleteItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the configuration for the catalog.
     * @param request GetCatalogConfigRequest
     * @return Async Task will return GetCatalogConfigResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetCatalogConfigResponse>> GetCatalogConfigAsync(final GetCatalogConfigRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetCatalogConfigResponse>>() {
            public PlayFabResult<GetCatalogConfigResponse> call() throws Exception {
                return privateGetCatalogConfigAsync(request);
            }
        });
    }

    /**
     * Gets the configuration for the catalog.
     * @param request GetCatalogConfigRequest
     * @return GetCatalogConfigResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetCatalogConfigResponse> GetCatalogConfig(final GetCatalogConfigRequest request) {
        FutureTask<PlayFabResult<GetCatalogConfigResponse>> task = new FutureTask(new Callable<PlayFabResult<GetCatalogConfigResponse>>() {
            public PlayFabResult<GetCatalogConfigResponse> call() throws Exception {
                return privateGetCatalogConfigAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetCatalogConfigResponse> exceptionResult = new PlayFabResult<GetCatalogConfigResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the configuration for the catalog. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetCatalogConfigResponse> privateGetCatalogConfigAsync(final GetCatalogConfigRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetCatalogConfig"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetCatalogConfigResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetCatalogConfigResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetCatalogConfigResponse>>(){}.getType());
        GetCatalogConfigResponse result = resultData.data;

        PlayFabResult<GetCatalogConfigResponse> pfResult = new PlayFabResult<GetCatalogConfigResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves an item from the working catalog. This item represents the current working state of the item.
     * @param request GetDraftItemRequest
     * @return Async Task will return GetDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetDraftItemResponse>> GetDraftItemAsync(final GetDraftItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetDraftItemResponse>>() {
            public PlayFabResult<GetDraftItemResponse> call() throws Exception {
                return privateGetDraftItemAsync(request);
            }
        });
    }

    /**
     * Retrieves an item from the working catalog. This item represents the current working state of the item.
     * @param request GetDraftItemRequest
     * @return GetDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetDraftItemResponse> GetDraftItem(final GetDraftItemRequest request) {
        FutureTask<PlayFabResult<GetDraftItemResponse>> task = new FutureTask(new Callable<PlayFabResult<GetDraftItemResponse>>() {
            public PlayFabResult<GetDraftItemResponse> call() throws Exception {
                return privateGetDraftItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetDraftItemResponse> exceptionResult = new PlayFabResult<GetDraftItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves an item from the working catalog. This item represents the current working state of the item. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetDraftItemResponse> privateGetDraftItemAsync(final GetDraftItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetDraftItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetDraftItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetDraftItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetDraftItemResponse>>(){}.getType());
        GetDraftItemResponse result = resultData.data;

        PlayFabResult<GetDraftItemResponse> pfResult = new PlayFabResult<GetDraftItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves a paginated list of the items from the draft catalog.
     * @param request GetDraftItemsRequest
     * @return Async Task will return GetDraftItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetDraftItemsResponse>> GetDraftItemsAsync(final GetDraftItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetDraftItemsResponse>>() {
            public PlayFabResult<GetDraftItemsResponse> call() throws Exception {
                return privateGetDraftItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves a paginated list of the items from the draft catalog.
     * @param request GetDraftItemsRequest
     * @return GetDraftItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetDraftItemsResponse> GetDraftItems(final GetDraftItemsRequest request) {
        FutureTask<PlayFabResult<GetDraftItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetDraftItemsResponse>>() {
            public PlayFabResult<GetDraftItemsResponse> call() throws Exception {
                return privateGetDraftItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetDraftItemsResponse> exceptionResult = new PlayFabResult<GetDraftItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves a paginated list of the items from the draft catalog. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetDraftItemsResponse> privateGetDraftItemsAsync(final GetDraftItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetDraftItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetDraftItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetDraftItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetDraftItemsResponse>>(){}.getType());
        GetDraftItemsResponse result = resultData.data;

        PlayFabResult<GetDraftItemsResponse> pfResult = new PlayFabResult<GetDraftItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves a paginated list of the items from the draft catalog created by the Entity.
     * @param request GetEntityDraftItemsRequest
     * @return Async Task will return GetEntityDraftItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityDraftItemsResponse>> GetEntityDraftItemsAsync(final GetEntityDraftItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityDraftItemsResponse>>() {
            public PlayFabResult<GetEntityDraftItemsResponse> call() throws Exception {
                return privateGetEntityDraftItemsAsync(request);
            }
        });
    }

    /**
     * Retrieves a paginated list of the items from the draft catalog created by the Entity.
     * @param request GetEntityDraftItemsRequest
     * @return GetEntityDraftItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityDraftItemsResponse> GetEntityDraftItems(final GetEntityDraftItemsRequest request) {
        FutureTask<PlayFabResult<GetEntityDraftItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityDraftItemsResponse>>() {
            public PlayFabResult<GetEntityDraftItemsResponse> call() throws Exception {
                return privateGetEntityDraftItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetEntityDraftItemsResponse> exceptionResult = new PlayFabResult<GetEntityDraftItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves a paginated list of the items from the draft catalog created by the Entity. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityDraftItemsResponse> privateGetEntityDraftItemsAsync(final GetEntityDraftItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetEntityDraftItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityDraftItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityDraftItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityDraftItemsResponse>>(){}.getType());
        GetEntityDraftItemsResponse result = resultData.data;

        PlayFabResult<GetEntityDraftItemsResponse> pfResult = new PlayFabResult<GetEntityDraftItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the submitted review for the specified item by the authenticated entity.
     * @param request GetEntityItemReviewRequest
     * @return Async Task will return GetEntityItemReviewResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetEntityItemReviewResponse>> GetEntityItemReviewAsync(final GetEntityItemReviewRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetEntityItemReviewResponse>>() {
            public PlayFabResult<GetEntityItemReviewResponse> call() throws Exception {
                return privateGetEntityItemReviewAsync(request);
            }
        });
    }

    /**
     * Gets the submitted review for the specified item by the authenticated entity.
     * @param request GetEntityItemReviewRequest
     * @return GetEntityItemReviewResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetEntityItemReviewResponse> GetEntityItemReview(final GetEntityItemReviewRequest request) {
        FutureTask<PlayFabResult<GetEntityItemReviewResponse>> task = new FutureTask(new Callable<PlayFabResult<GetEntityItemReviewResponse>>() {
            public PlayFabResult<GetEntityItemReviewResponse> call() throws Exception {
                return privateGetEntityItemReviewAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetEntityItemReviewResponse> exceptionResult = new PlayFabResult<GetEntityItemReviewResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the submitted review for the specified item by the authenticated entity. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetEntityItemReviewResponse> privateGetEntityItemReviewAsync(final GetEntityItemReviewRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetEntityItemReview"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetEntityItemReviewResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetEntityItemReviewResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetEntityItemReviewResponse>>(){}.getType());
        GetEntityItemReviewResponse result = resultData.data;

        PlayFabResult<GetEntityItemReviewResponse> pfResult = new PlayFabResult<GetEntityItemReviewResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Retrieves an item from the public catalog.
     * @param request GetItemRequest
     * @return Async Task will return GetItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemResponse>> GetItemAsync(final GetItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemResponse>>() {
            public PlayFabResult<GetItemResponse> call() throws Exception {
                return privateGetItemAsync(request);
            }
        });
    }

    /**
     * Retrieves an item from the public catalog.
     * @param request GetItemRequest
     * @return GetItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemResponse> GetItem(final GetItemRequest request) {
        FutureTask<PlayFabResult<GetItemResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemResponse>>() {
            public PlayFabResult<GetItemResponse> call() throws Exception {
                return privateGetItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemResponse> exceptionResult = new PlayFabResult<GetItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Retrieves an item from the public catalog. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemResponse> privateGetItemAsync(final GetItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemResponse>>(){}.getType());
        GetItemResponse result = resultData.data;

        PlayFabResult<GetItemResponse> pfResult = new PlayFabResult<GetItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the moderation state for an item, including the concern category and string reason.
     * @param request GetItemModerationStateRequest
     * @return Async Task will return GetItemModerationStateResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemModerationStateResponse>> GetItemModerationStateAsync(final GetItemModerationStateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemModerationStateResponse>>() {
            public PlayFabResult<GetItemModerationStateResponse> call() throws Exception {
                return privateGetItemModerationStateAsync(request);
            }
        });
    }

    /**
     * Gets the moderation state for an item, including the concern category and string reason.
     * @param request GetItemModerationStateRequest
     * @return GetItemModerationStateResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemModerationStateResponse> GetItemModerationState(final GetItemModerationStateRequest request) {
        FutureTask<PlayFabResult<GetItemModerationStateResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemModerationStateResponse>>() {
            public PlayFabResult<GetItemModerationStateResponse> call() throws Exception {
                return privateGetItemModerationStateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemModerationStateResponse> exceptionResult = new PlayFabResult<GetItemModerationStateResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the moderation state for an item, including the concern category and string reason. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemModerationStateResponse> privateGetItemModerationStateAsync(final GetItemModerationStateRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItemModerationState"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemModerationStateResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemModerationStateResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemModerationStateResponse>>(){}.getType());
        GetItemModerationStateResponse result = resultData.data;

        PlayFabResult<GetItemModerationStateResponse> pfResult = new PlayFabResult<GetItemModerationStateResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Gets the status of a publish of an item.
     * @param request GetItemPublishStatusRequest
     * @return Async Task will return GetItemPublishStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemPublishStatusResponse>> GetItemPublishStatusAsync(final GetItemPublishStatusRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemPublishStatusResponse>>() {
            public PlayFabResult<GetItemPublishStatusResponse> call() throws Exception {
                return privateGetItemPublishStatusAsync(request);
            }
        });
    }

    /**
     * Gets the status of a publish of an item.
     * @param request GetItemPublishStatusRequest
     * @return GetItemPublishStatusResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemPublishStatusResponse> GetItemPublishStatus(final GetItemPublishStatusRequest request) {
        FutureTask<PlayFabResult<GetItemPublishStatusResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemPublishStatusResponse>>() {
            public PlayFabResult<GetItemPublishStatusResponse> call() throws Exception {
                return privateGetItemPublishStatusAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemPublishStatusResponse> exceptionResult = new PlayFabResult<GetItemPublishStatusResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Gets the status of a publish of an item. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemPublishStatusResponse> privateGetItemPublishStatusAsync(final GetItemPublishStatusRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItemPublishStatus"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemPublishStatusResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemPublishStatusResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemPublishStatusResponse>>(){}.getType());
        GetItemPublishStatusResponse result = resultData.data;

        PlayFabResult<GetItemPublishStatusResponse> pfResult = new PlayFabResult<GetItemPublishStatusResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get a paginated set of reviews associated with the specified item.
     * @param request GetItemReviewsRequest
     * @return Async Task will return GetItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemReviewsResponse>> GetItemReviewsAsync(final GetItemReviewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemReviewsResponse>>() {
            public PlayFabResult<GetItemReviewsResponse> call() throws Exception {
                return privateGetItemReviewsAsync(request);
            }
        });
    }

    /**
     * Get a paginated set of reviews associated with the specified item.
     * @param request GetItemReviewsRequest
     * @return GetItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemReviewsResponse> GetItemReviews(final GetItemReviewsRequest request) {
        FutureTask<PlayFabResult<GetItemReviewsResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemReviewsResponse>>() {
            public PlayFabResult<GetItemReviewsResponse> call() throws Exception {
                return privateGetItemReviewsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemReviewsResponse> exceptionResult = new PlayFabResult<GetItemReviewsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get a paginated set of reviews associated with the specified item. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemReviewsResponse> privateGetItemReviewsAsync(final GetItemReviewsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItemReviews"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemReviewsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemReviewsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemReviewsResponse>>(){}.getType());
        GetItemReviewsResponse result = resultData.data;

        PlayFabResult<GetItemReviewsResponse> pfResult = new PlayFabResult<GetItemReviewsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Get a summary of all reviews associated with the specified item.
     * @param request GetItemReviewSummaryRequest
     * @return Async Task will return GetItemReviewSummaryResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<GetItemReviewSummaryResponse>> GetItemReviewSummaryAsync(final GetItemReviewSummaryRequest request) {
        return new FutureTask(new Callable<PlayFabResult<GetItemReviewSummaryResponse>>() {
            public PlayFabResult<GetItemReviewSummaryResponse> call() throws Exception {
                return privateGetItemReviewSummaryAsync(request);
            }
        });
    }

    /**
     * Get a summary of all reviews associated with the specified item.
     * @param request GetItemReviewSummaryRequest
     * @return GetItemReviewSummaryResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<GetItemReviewSummaryResponse> GetItemReviewSummary(final GetItemReviewSummaryRequest request) {
        FutureTask<PlayFabResult<GetItemReviewSummaryResponse>> task = new FutureTask(new Callable<PlayFabResult<GetItemReviewSummaryResponse>>() {
            public PlayFabResult<GetItemReviewSummaryResponse> call() throws Exception {
                return privateGetItemReviewSummaryAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<GetItemReviewSummaryResponse> exceptionResult = new PlayFabResult<GetItemReviewSummaryResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Get a summary of all reviews associated with the specified item. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<GetItemReviewSummaryResponse> privateGetItemReviewSummaryAsync(final GetItemReviewSummaryRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/GetItemReviewSummary"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<GetItemReviewSummaryResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<GetItemReviewSummaryResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<GetItemReviewSummaryResponse>>(){}.getType());
        GetItemReviewSummaryResponse result = resultData.data;

        PlayFabResult<GetItemReviewSummaryResponse> pfResult = new PlayFabResult<GetItemReviewSummaryResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Initiates a publish of an item from the working catalog to the public catalog.
     * @param request PublishDraftItemRequest
     * @return Async Task will return PublishDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<PublishDraftItemResponse>> PublishDraftItemAsync(final PublishDraftItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<PublishDraftItemResponse>>() {
            public PlayFabResult<PublishDraftItemResponse> call() throws Exception {
                return privatePublishDraftItemAsync(request);
            }
        });
    }

    /**
     * Initiates a publish of an item from the working catalog to the public catalog.
     * @param request PublishDraftItemRequest
     * @return PublishDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<PublishDraftItemResponse> PublishDraftItem(final PublishDraftItemRequest request) {
        FutureTask<PlayFabResult<PublishDraftItemResponse>> task = new FutureTask(new Callable<PlayFabResult<PublishDraftItemResponse>>() {
            public PlayFabResult<PublishDraftItemResponse> call() throws Exception {
                return privatePublishDraftItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<PublishDraftItemResponse> exceptionResult = new PlayFabResult<PublishDraftItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Initiates a publish of an item from the working catalog to the public catalog. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<PublishDraftItemResponse> privatePublishDraftItemAsync(final PublishDraftItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/PublishDraftItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<PublishDraftItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<PublishDraftItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<PublishDraftItemResponse>>(){}.getType());
        PublishDraftItemResponse result = resultData.data;

        PlayFabResult<PublishDraftItemResponse> pfResult = new PlayFabResult<PublishDraftItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Submit a report for an item, indicating in what way the item is inappropriate.
     * @param request ReportItemRequest
     * @return Async Task will return ReportItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ReportItemResponse>> ReportItemAsync(final ReportItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ReportItemResponse>>() {
            public PlayFabResult<ReportItemResponse> call() throws Exception {
                return privateReportItemAsync(request);
            }
        });
    }

    /**
     * Submit a report for an item, indicating in what way the item is inappropriate.
     * @param request ReportItemRequest
     * @return ReportItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ReportItemResponse> ReportItem(final ReportItemRequest request) {
        FutureTask<PlayFabResult<ReportItemResponse>> task = new FutureTask(new Callable<PlayFabResult<ReportItemResponse>>() {
            public PlayFabResult<ReportItemResponse> call() throws Exception {
                return privateReportItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ReportItemResponse> exceptionResult = new PlayFabResult<ReportItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Submit a report for an item, indicating in what way the item is inappropriate. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ReportItemResponse> privateReportItemAsync(final ReportItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/ReportItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ReportItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ReportItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ReportItemResponse>>(){}.getType());
        ReportItemResponse result = resultData.data;

        PlayFabResult<ReportItemResponse> pfResult = new PlayFabResult<ReportItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Submit a report for a review
     * @param request ReportItemReviewRequest
     * @return Async Task will return ReportItemReviewResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ReportItemReviewResponse>> ReportItemReviewAsync(final ReportItemReviewRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ReportItemReviewResponse>>() {
            public PlayFabResult<ReportItemReviewResponse> call() throws Exception {
                return privateReportItemReviewAsync(request);
            }
        });
    }

    /**
     * Submit a report for a review
     * @param request ReportItemReviewRequest
     * @return ReportItemReviewResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ReportItemReviewResponse> ReportItemReview(final ReportItemReviewRequest request) {
        FutureTask<PlayFabResult<ReportItemReviewResponse>> task = new FutureTask(new Callable<PlayFabResult<ReportItemReviewResponse>>() {
            public PlayFabResult<ReportItemReviewResponse> call() throws Exception {
                return privateReportItemReviewAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ReportItemReviewResponse> exceptionResult = new PlayFabResult<ReportItemReviewResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Submit a report for a review */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ReportItemReviewResponse> privateReportItemReviewAsync(final ReportItemReviewRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/ReportItemReview"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ReportItemReviewResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ReportItemReviewResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ReportItemReviewResponse>>(){}.getType());
        ReportItemReviewResponse result = resultData.data;

        PlayFabResult<ReportItemReviewResponse> pfResult = new PlayFabResult<ReportItemReviewResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Creates or updates a review for the specified item.
     * @param request ReviewItemRequest
     * @return Async Task will return ReviewItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<ReviewItemResponse>> ReviewItemAsync(final ReviewItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<ReviewItemResponse>>() {
            public PlayFabResult<ReviewItemResponse> call() throws Exception {
                return privateReviewItemAsync(request);
            }
        });
    }

    /**
     * Creates or updates a review for the specified item.
     * @param request ReviewItemRequest
     * @return ReviewItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<ReviewItemResponse> ReviewItem(final ReviewItemRequest request) {
        FutureTask<PlayFabResult<ReviewItemResponse>> task = new FutureTask(new Callable<PlayFabResult<ReviewItemResponse>>() {
            public PlayFabResult<ReviewItemResponse> call() throws Exception {
                return privateReviewItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<ReviewItemResponse> exceptionResult = new PlayFabResult<ReviewItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Creates or updates a review for the specified item. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<ReviewItemResponse> privateReviewItemAsync(final ReviewItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/ReviewItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<ReviewItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<ReviewItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<ReviewItemResponse>>(){}.getType());
        ReviewItemResponse result = resultData.data;

        PlayFabResult<ReviewItemResponse> pfResult = new PlayFabResult<ReviewItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Executes a search against the public catalog using the provided search parameters and returns a set of paginated
     * results.
     * @param request SearchItemsRequest
     * @return Async Task will return SearchItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SearchItemsResponse>> SearchItemsAsync(final SearchItemsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SearchItemsResponse>>() {
            public PlayFabResult<SearchItemsResponse> call() throws Exception {
                return privateSearchItemsAsync(request);
            }
        });
    }

    /**
     * Executes a search against the public catalog using the provided search parameters and returns a set of paginated
     * results.
     * @param request SearchItemsRequest
     * @return SearchItemsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SearchItemsResponse> SearchItems(final SearchItemsRequest request) {
        FutureTask<PlayFabResult<SearchItemsResponse>> task = new FutureTask(new Callable<PlayFabResult<SearchItemsResponse>>() {
            public PlayFabResult<SearchItemsResponse> call() throws Exception {
                return privateSearchItemsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SearchItemsResponse> exceptionResult = new PlayFabResult<SearchItemsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /**
     * Executes a search against the public catalog using the provided search parameters and returns a set of paginated
     * results.
     */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SearchItemsResponse> privateSearchItemsAsync(final SearchItemsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/SearchItems"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SearchItemsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SearchItemsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SearchItemsResponse>>(){}.getType());
        SearchItemsResponse result = resultData.data;

        PlayFabResult<SearchItemsResponse> pfResult = new PlayFabResult<SearchItemsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Sets the moderation state for an item, including the concern category and string reason.
     * @param request SetItemModerationStateRequest
     * @return Async Task will return SetItemModerationStateResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SetItemModerationStateResponse>> SetItemModerationStateAsync(final SetItemModerationStateRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SetItemModerationStateResponse>>() {
            public PlayFabResult<SetItemModerationStateResponse> call() throws Exception {
                return privateSetItemModerationStateAsync(request);
            }
        });
    }

    /**
     * Sets the moderation state for an item, including the concern category and string reason.
     * @param request SetItemModerationStateRequest
     * @return SetItemModerationStateResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SetItemModerationStateResponse> SetItemModerationState(final SetItemModerationStateRequest request) {
        FutureTask<PlayFabResult<SetItemModerationStateResponse>> task = new FutureTask(new Callable<PlayFabResult<SetItemModerationStateResponse>>() {
            public PlayFabResult<SetItemModerationStateResponse> call() throws Exception {
                return privateSetItemModerationStateAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SetItemModerationStateResponse> exceptionResult = new PlayFabResult<SetItemModerationStateResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Sets the moderation state for an item, including the concern category and string reason. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SetItemModerationStateResponse> privateSetItemModerationStateAsync(final SetItemModerationStateRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/SetItemModerationState"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SetItemModerationStateResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SetItemModerationStateResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SetItemModerationStateResponse>>(){}.getType());
        SetItemModerationStateResponse result = resultData.data;

        PlayFabResult<SetItemModerationStateResponse> pfResult = new PlayFabResult<SetItemModerationStateResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Submit a vote for a review, indicating whether the review was helpful or unhelpful.
     * @param request SubmitItemReviewVoteRequest
     * @return Async Task will return SubmitItemReviewVoteResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<SubmitItemReviewVoteResponse>> SubmitItemReviewVoteAsync(final SubmitItemReviewVoteRequest request) {
        return new FutureTask(new Callable<PlayFabResult<SubmitItemReviewVoteResponse>>() {
            public PlayFabResult<SubmitItemReviewVoteResponse> call() throws Exception {
                return privateSubmitItemReviewVoteAsync(request);
            }
        });
    }

    /**
     * Submit a vote for a review, indicating whether the review was helpful or unhelpful.
     * @param request SubmitItemReviewVoteRequest
     * @return SubmitItemReviewVoteResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<SubmitItemReviewVoteResponse> SubmitItemReviewVote(final SubmitItemReviewVoteRequest request) {
        FutureTask<PlayFabResult<SubmitItemReviewVoteResponse>> task = new FutureTask(new Callable<PlayFabResult<SubmitItemReviewVoteResponse>>() {
            public PlayFabResult<SubmitItemReviewVoteResponse> call() throws Exception {
                return privateSubmitItemReviewVoteAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<SubmitItemReviewVoteResponse> exceptionResult = new PlayFabResult<SubmitItemReviewVoteResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Submit a vote for a review, indicating whether the review was helpful or unhelpful. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<SubmitItemReviewVoteResponse> privateSubmitItemReviewVoteAsync(final SubmitItemReviewVoteRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/SubmitItemReviewVote"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<SubmitItemReviewVoteResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<SubmitItemReviewVoteResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<SubmitItemReviewVoteResponse>>(){}.getType());
        SubmitItemReviewVoteResponse result = resultData.data;

        PlayFabResult<SubmitItemReviewVoteResponse> pfResult = new PlayFabResult<SubmitItemReviewVoteResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Submit a request to takedown one or more reviews.
     * @param request TakedownItemReviewsRequest
     * @return Async Task will return TakedownItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<TakedownItemReviewsResponse>> TakedownItemReviewsAsync(final TakedownItemReviewsRequest request) {
        return new FutureTask(new Callable<PlayFabResult<TakedownItemReviewsResponse>>() {
            public PlayFabResult<TakedownItemReviewsResponse> call() throws Exception {
                return privateTakedownItemReviewsAsync(request);
            }
        });
    }

    /**
     * Submit a request to takedown one or more reviews.
     * @param request TakedownItemReviewsRequest
     * @return TakedownItemReviewsResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<TakedownItemReviewsResponse> TakedownItemReviews(final TakedownItemReviewsRequest request) {
        FutureTask<PlayFabResult<TakedownItemReviewsResponse>> task = new FutureTask(new Callable<PlayFabResult<TakedownItemReviewsResponse>>() {
            public PlayFabResult<TakedownItemReviewsResponse> call() throws Exception {
                return privateTakedownItemReviewsAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<TakedownItemReviewsResponse> exceptionResult = new PlayFabResult<TakedownItemReviewsResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Submit a request to takedown one or more reviews. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<TakedownItemReviewsResponse> privateTakedownItemReviewsAsync(final TakedownItemReviewsRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/TakedownItemReviews"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<TakedownItemReviewsResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<TakedownItemReviewsResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<TakedownItemReviewsResponse>>(){}.getType());
        TakedownItemReviewsResponse result = resultData.data;

        PlayFabResult<TakedownItemReviewsResponse> pfResult = new PlayFabResult<TakedownItemReviewsResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Updates the configuration for the catalog.
     * @param request UpdateCatalogConfigRequest
     * @return Async Task will return UpdateCatalogConfigResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateCatalogConfigResponse>> UpdateCatalogConfigAsync(final UpdateCatalogConfigRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateCatalogConfigResponse>>() {
            public PlayFabResult<UpdateCatalogConfigResponse> call() throws Exception {
                return privateUpdateCatalogConfigAsync(request);
            }
        });
    }

    /**
     * Updates the configuration for the catalog.
     * @param request UpdateCatalogConfigRequest
     * @return UpdateCatalogConfigResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateCatalogConfigResponse> UpdateCatalogConfig(final UpdateCatalogConfigRequest request) {
        FutureTask<PlayFabResult<UpdateCatalogConfigResponse>> task = new FutureTask(new Callable<PlayFabResult<UpdateCatalogConfigResponse>>() {
            public PlayFabResult<UpdateCatalogConfigResponse> call() throws Exception {
                return privateUpdateCatalogConfigAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateCatalogConfigResponse> exceptionResult = new PlayFabResult<UpdateCatalogConfigResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Updates the configuration for the catalog. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateCatalogConfigResponse> privateUpdateCatalogConfigAsync(final UpdateCatalogConfigRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/UpdateCatalogConfig"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateCatalogConfigResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateCatalogConfigResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateCatalogConfigResponse>>(){}.getType());
        UpdateCatalogConfigResponse result = resultData.data;

        PlayFabResult<UpdateCatalogConfigResponse> pfResult = new PlayFabResult<UpdateCatalogConfigResponse>();
        pfResult.Result = result;
        return pfResult;
    }

    /**
     * Update the metadata for an item in the working catalog.
     * @param request UpdateDraftItemRequest
     * @return Async Task will return UpdateDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static FutureTask<PlayFabResult<UpdateDraftItemResponse>> UpdateDraftItemAsync(final UpdateDraftItemRequest request) {
        return new FutureTask(new Callable<PlayFabResult<UpdateDraftItemResponse>>() {
            public PlayFabResult<UpdateDraftItemResponse> call() throws Exception {
                return privateUpdateDraftItemAsync(request);
            }
        });
    }

    /**
     * Update the metadata for an item in the working catalog.
     * @param request UpdateDraftItemRequest
     * @return UpdateDraftItemResponse
     */
    @SuppressWarnings("unchecked")
    public static PlayFabResult<UpdateDraftItemResponse> UpdateDraftItem(final UpdateDraftItemRequest request) {
        FutureTask<PlayFabResult<UpdateDraftItemResponse>> task = new FutureTask(new Callable<PlayFabResult<UpdateDraftItemResponse>>() {
            public PlayFabResult<UpdateDraftItemResponse> call() throws Exception {
                return privateUpdateDraftItemAsync(request);
            }
        });
        try {
            task.run();
            return task.get();
        } catch(Exception e) {
            PlayFabResult<UpdateDraftItemResponse> exceptionResult = new PlayFabResult<UpdateDraftItemResponse>();
            exceptionResult.Error = PlayFabHTTP.GeneratePfError(-1, PlayFabErrorCode.Unknown, e.getMessage(), null, null);
            return exceptionResult;
        }
    }

    /** Update the metadata for an item in the working catalog. */
    @SuppressWarnings("unchecked")
    private static PlayFabResult<UpdateDraftItemResponse> privateUpdateDraftItemAsync(final UpdateDraftItemRequest request) throws Exception {
        if (PlayFabSettings.EntityToken == null) throw new Exception ("Must call GetEntityToken before you can use the Entity API");

        FutureTask<Object> task = PlayFabHTTP.doPost(PlayFabSettings.GetURL("/Catalog/UpdateDraftItem"), request, "X-EntityToken", PlayFabSettings.EntityToken);
        task.run();
        Object httpResult = task.get();
        if (httpResult instanceof PlayFabError) {
            PlayFabError error = (PlayFabError)httpResult;
            if (PlayFabSettings.GlobalErrorHandler != null)
                PlayFabSettings.GlobalErrorHandler.callback(error);
            PlayFabResult result = new PlayFabResult<UpdateDraftItemResponse>();
            result.Error = error;
            return result;
        }
        String resultRawJson = (String) httpResult;

        PlayFabJsonSuccess<UpdateDraftItemResponse> resultData = gson.fromJson(resultRawJson, new TypeToken<PlayFabJsonSuccess<UpdateDraftItemResponse>>(){}.getType());
        UpdateDraftItemResponse result = resultData.data;

        PlayFabResult<UpdateDraftItemResponse> pfResult = new PlayFabResult<UpdateDraftItemResponse>();
        pfResult.Result = result;
        return pfResult;
    }

}
