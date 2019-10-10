package experiment.lucene;

//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.core.SimpleAnalyzer;
//import org.apache.lucene.codecs.Codec;
//import org.apache.lucene.codecs.simpletext.SimpleTextCodec;
//import org.apache.lucene.document.*;
//import org.apache.lucene.index.*;
//import org.apache.lucene.search.BooleanClause.Occur;
//import org.apache.lucene.search.*;
//import org.apache.lucene.search.BooleanQuery.Builder;
//import org.apache.lucene.search.similarities.ClassicSimilarity;
//import org.apache.lucene.search.similarities.Similarity;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.NIOFSDirectory;
//import org.apache.lucene.util.BytesRef;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
///**
// * @author haze
// * @date created at 2018/3/2 上午10:30
// */
//public class LuceneTest {
//
//
//    /**
//     * 数据目录.
//     */
//    private Path path = Paths.get("e:/lucene/");
//
//    /**
//     * 建立索引.
//     *
//     * @param base
//     */
//    private void index(int base) {
//        try {
//            Directory directory = NIOFSDirectory.open(path);
//            Similarity similarity = new ClassicSimilarity();
//            Analyzer analyzer = new SimpleAnalyzer();
//            Codec codec = new SimpleTextCodec();
//            IndexWriterConfig config = new IndexWriterConfig(analyzer);
//            config.setCodec(codec);
//            config.setSimilarity(similarity);
//            config.setUseCompoundFile(false);
//            IndexWriter iwriter = new IndexWriter(directory, config);
//            for (int i = base; i < base + 5; i++) {
//                Document doc = new Document();
//
//                String empty = " ";
//                String title = "doc " + i + " title";
//                FieldType titleType = new FieldType();
//                titleType.storeTermVectors();
//                titleType.setStored(true);
//                titleType.setTokenized(true);
//                titleType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
//                Field titleField = new Field("title", title, titleType);
//                doc.add(titleField);
//
//                Field level = new NumericDocValuesField("level", i);
//                BytesRef bytes = new BytesRef(("athor " + i).getBytes());
//                Field athor = new SortedDocValuesField("atuor", bytes);
//
//                doc.add(level);
//                doc.add(athor);
//
//                String content = "doc " + i + " content";
//                FieldType contentType = new FieldType();
//                contentType.storeTermVectors();
//                contentType.setStored(true);
//                contentType.setTokenized(true);
//                contentType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
//                Field contentField = new Field("content", content, contentType);
//                doc.add(contentField);
//
//                iwriter.addDocument(doc);
//            }
//            iwriter.commit();
//            iwriter.forceMerge(1, true);
//            iwriter.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void search(IndexSearcher isearcher) {
//        try {
//            Query must = new TermQuery(new Term("title", "title"));
//            Query not = new TermQuery(new Term("title", "doc2"));
//            Query should = new TermQuery(new Term("content", "content"));
//
//            Builder builder = new Builder();
//            builder.add(must, Occur.MUST);
//            builder.add(not, Occur.MUST_NOT);
//            builder.add(should, Occur.SHOULD);
//            BooleanQuery query = builder.build();
//            TopDocs topDocs = isearcher.search(query, 10);
//
//            ScoreDoc[] hits = topDocs.scoreDocs;
//            // Iterate through the results:
//            for (int i = 0; i < hits.length; i++) {
//                Document hitDoc = isearcher.doc(hits[i].doc);
//                System.out.println(isearcher.getIndexReader().toString() + ":" + hitDoc);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private IndexSearcher getSearcher() {
//        try {
//            Directory directory = NIOFSDirectory.open(path);
//            // Now search the index:
//            final DirectoryReader ireader = DirectoryReader.open(directory);
//            IndexSearcher isearcher = new IndexSearcher(ireader);
//            return isearcher;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        LuceneTest te = new LuceneTest();
//        te.index(0);
//    }
//
//}
